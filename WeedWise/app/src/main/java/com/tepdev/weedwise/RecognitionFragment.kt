package com.tepdev.weedwise


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tepdev.weedwise.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder

class RecognitionFragment : Fragment()  {

    private lateinit var galleryButton: Button
    private lateinit var picture: Button
    private val imageSize = 224

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recognition, container, false)

        picture = view.findViewById(R.id.button)
        galleryButton = view.findViewById(R.id.gallery)

        picture.setOnClickListener {
            // Launch camera if we have permission
            if (requireContext().checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1)
            } else {
                // Request camera permission if we don't have it.
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }
        }
        galleryButton.setOnClickListener { // Make sure the click listener is correctly set for the galleryButton
            openGallery()
        }

        return view
    }
    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        galleryIntent.type = "image/*"
        startActivityForResult(galleryIntent, 2) // Use a unique request code (e.g., 2) for the gallery picker
    }
    // You can create a mapping from class labels to additional information
       private val classInfoMap by lazy {
        mapOf(
            "Eleusine Indica" to ClassInfo("Goose Grass","Pad-pad, Bikad-Bikad, Paragis, Parangis ","Poaceae", "PANPU", "Grass", "rainfed lowland ricefield","Perennial","seeds",getString(R.string.char_eleusine_indica),getString(R.string.imp_eleusine_indica)),
            "Echinochloa Colona" to ClassInfo("Banyard Grass","Dukayang, Pulang-pwet, Ikog-iring","Poaceae", "ECHCO", "Grass", "irrigated and rainfed lowland ricefields","Annual","seeds",getString(R.string.char_colona),getString(R.string.imp_colona)),
            "Paspalum Conjugatum" to ClassInfo("Carabao Grass","Lakatan, Kulape, Laau-laau","Poaceae", "PANPU", "Grass", "rainfed lowland ricefields ","Perennial","seeds and stem cuttings",getString(R.string.char_conjagatum),getString(R.string.char_conjagatum)),
            "Cyperus Iria" to ClassInfo("Rice Flatsedge","Alinang, paiung,-paiung, sud-sud, taga-taga (Bik.); okokiang (Bon.)","Cyperaceae", "IRIIRI", "Sedges", "irrigated and rainfed lowland ricefields","Perennial","seeds",getString(R.string.char_iria),getString(R.string.imp_iria)),
            "Cyperus Brevifolius" to ClassInfo("Shortleaf Spikesedge","Barang","Cyperaceae", "BREBRE", "Sedges", "irrigated and rainfed lowland ricefields","Perennial","seeds",getString(R.string.char_cyperus),getString(R.string.imp_cyperus)),
            "Hydrocotyle Umbellata" to ClassInfo("Dollar Weed","Takip-kuhol, Jahong-jahong","Araliaceae", "HYDUHB", "Broadleaves", "irrigated lowland ricefields","Perennial","seeds",getString(R.string.char_umbelleta),getString(R.string.imp_umbelleta)),
            "Ipomoea Aquatica" to ClassInfo("Water Spinach","Kang-kong, Tangkong","Convolvulaceae", "IPOMAQ", "Broadleaves", "irrigated lowland ricefields","Perennial","seeds and cuttings",getString(R.string.char_ipomea),getString(R.string.imp_ipomea))
            // Add more mappings for other class labels
        )
    }
    private val classImages = intArrayOf(
        R.drawable.grassindica,
        R.drawable.grasscolona,
        R.drawable.grassconjugatum,
        R.drawable.sedgesiria,
        R.drawable.sedgesbrevifolius,
        R.drawable.broadhydrocotyle,
        R.drawable.broadpomoea
    )


    private data class ClassInfo(
        val englishName: String,
        val localName: String,
        val family: String,
        val eppoCode: String,
        val morphological: String,
        val growsIn: String,
        val lifeCycle: String,
        val reproduction: String,
        val characteristic: String,
        val impact: String
    )

    private fun classifyImage(image: Bitmap): String {
        try {
            val model = Model.newInstance(requireContext())

            // Creates inputs for reference.
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
            val byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3)
            byteBuffer.order(ByteOrder.nativeOrder())

            // Get a 1D array of 224 * 224 pixels in the image
            val intValues = IntArray(imageSize * imageSize)
            image.getPixels(intValues, 0, image.width, 0, 0, image.width, image.height)

            // Iterate over pixels and extract R, G, and B values. Add to byte buffer.
            var pixel = 0
            for (i in 0 until imageSize) {
                for (j in 0 until imageSize) {
                    val value = intValues[pixel++] // RGB
                    byteBuffer.putFloat(((value shr 16) and 0xFF) * (1.0f / 255.0f))
                    byteBuffer.putFloat(((value shr 8) and 0xFF) * (1.0f / 255.0f))
                    byteBuffer.putFloat((value and 0xFF) * (1.0f / 255.0f))
                }
            }

            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets the result.
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.getOutputFeature0AsTensorBuffer()

            val confidences = outputFeature0.floatArray
            // Find the index of the class with the biggest confidence.
            var maxPos = 0
            var maxConfidence = 0.0f
            for (i in confidences.indices) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i]
                    maxPos = i
                }
            }
            val classes = arrayOf(
                "Eleusine Indica",
                "Echinochloa Colona",
                "Paspalum Conjugatum",
                "Cyperus Iria",
                "Cyperus Brevifolius",
                "Hydrocotyle Umbellata",
                "Ipomoea Aquatica")


            // Release model resources if no longer used.
            model.close()
            return classes[maxPos]
        } catch (e: IOException) {

            return ""
        }
    }
    private fun isWeedImage(image: Bitmap): Boolean {
        val classLabel = classifyImage(image)
        return classInfoMap.containsKey(classLabel)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val classes = classInfoMap.keys.toTypedArray()
        if (requestCode == 1 && resultCode == AppCompatActivity.RESULT_OK) {
            val image = data?.extras?.get("data") as Bitmap
            val dimension = minOf(image.width, image.height)
            val thumbnailImage = ThumbnailUtils.extractThumbnail(image, dimension, dimension)
            val scaledImage = Bitmap.createScaledBitmap(thumbnailImage, imageSize, imageSize, false)
            val classLabel = classifyImage(scaledImage)

            val isWeed = isWeedImage(scaledImage)

            if (isWeed) {
        // Get additional labels based on classLabel
        val classInfo = classInfoMap[classLabel]

        // Pass the classLabel, image, and additional labels to the ResultActivity
        val intent = Intent(requireContext(), ResultActivity::class.java)
        intent.putExtra("result", classLabel)
        intent.putExtra(
            "imageResourceId",
            classImages[classes.indexOf(classLabel)]
        ) // Pass the image resource ID

        if (classInfo != null) {
            intent.putExtra("englishName", classInfo.englishName)
            intent.putExtra("localName", classInfo.localName)
            intent.putExtra("family", classInfo.family)
            intent.putExtra("eppoCode", classInfo.eppoCode)
            intent.putExtra("morphological", classInfo.morphological)
            intent.putExtra("growsIn", classInfo.growsIn)
            intent.putExtra("lifeCycle", classInfo.lifeCycle)
            intent.putExtra("reproduction", classInfo.reproduction)
            intent.putExtra("characteristic", classInfo.characteristic)
            intent.putExtra("impact", classInfo.impact)

        }

        startActivity(intent)
    } else {
        val intent =Intent(requireContext(), ResultActivity::class.java)
                intent.putExtra("result", "Not Recognized as Weed")
                startActivity(intent)
            }
        } else if (requestCode == 2 && resultCode == AppCompatActivity.RESULT_OK) {
            // Handle gallery image selection
            val selectedImage = data?.data
            val imageBitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, selectedImage)
            val dimension = minOf(imageBitmap.width, imageBitmap.height)
            val thumbnailImage = ThumbnailUtils.extractThumbnail(imageBitmap, dimension, dimension)
            val scaledImage = Bitmap.createScaledBitmap(thumbnailImage, imageSize, imageSize, false)
            val classLabel = classifyImage(scaledImage)

            // Get additional labels based on classLabel
            val classInfo = classInfoMap[classLabel]

            // Pass the classLabel, image, and additional labels to the ResultActivity
            val intent = Intent(requireContext(), ResultActivity::class.java)
            intent.putExtra("result", classLabel)
            intent.putExtra("imageResourceId", classImages[classes.indexOf(classLabel)]) // Pass the image resource ID

            if (classInfo != null) {
                intent.putExtra("englishName", classInfo.englishName)
                intent.putExtra("localName", classInfo.localName)
                intent.putExtra("family", classInfo.family)
                intent.putExtra("eppoCode", classInfo.eppoCode)
                intent.putExtra("morphological", classInfo.morphological)
                intent.putExtra("growsIn", classInfo.growsIn)
                intent.putExtra("lifeCycle", classInfo.lifeCycle)
                intent.putExtra("reproduction", classInfo.reproduction)
                intent.putExtra("characteristic",classInfo.characteristic)
                intent.putExtra("impact",classInfo.impact)

            }

            startActivity(intent)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}


