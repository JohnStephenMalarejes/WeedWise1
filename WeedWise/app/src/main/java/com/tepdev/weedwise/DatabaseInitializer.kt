package com.tepdev.weedwise

import android.content.Context
import androidx.core.content.res.TypedArrayUtils.getString

class DatabaseInitializer(private val context: Context) {
    fun initializeDatabase() {
        val dbHelper = WeedDatabaseHelper(context)

        // Sample data for sedges (insert 1 image at a time)
        val sedgesImageResources = arrayOf(
            R.drawable.sedgesacuta, R.drawable.sedgesbrevifolius, R.drawable.sedgesiria,
            R.drawable.sedgesdifformis, R.drawable.sedgesmiliacea, R.drawable.sedgesjuncoides,
            R.drawable.sedgesmucronatus, R.drawable.sedgesrotundus, R.drawable.sedgesschoenoides,
            R.drawable.sedgesumbellata
        )
        val sedgesScientificNames = arrayOf(
            "Eleocharis acuta\n(needle spikerush)", "Cyperus Brevifolius\n(short-leaved sedge)", "Cyperus iria\n(ricefield sedge)",
            "Cyperus difformis\n(variable sedge)", "Fimbristylis miliacea\n(creeping fimbristylis) ", "Scirpus juncoides\n(leafy bulrush)",
            "Scirpus mucronatus\n(alkali bulrush)", "Cyperus rotundus\n(purple nutsedge", "Fimbristylis schoenoides\n(annual fimbristylis)",
            "Fuirena umbellata\n(umbrella fuirena)"
        )
        val sedgeslocalName = arrayOf(
            "Sambong-Saging, Banakal ","Barang","Alinang, paiung,-paiung, sud-sud",
            " Baong-baong, buto-butones, payong payong","Bungot-bungot, buntot-pusa","Apulid, bitubituinan, balbas-kalabaw",
            "Tubong babae, Tubong baklay","Barsanga, mutha, sudsud","Sibuyas-sibuyasan",
            "Gigante"
        )
        val sedgesFamily = arrayOf(
            "Cyperaceae","Cyperaceae", "Cyperaceae","Cyperaceae", "Cyperaceae","Cyperaceae", "Cyperaceae","Cyperaceae", "Cyperaceae","Cyperaceae"
            )
        val sedgesEppoCode = arrayOf(
            "ELEAC","CYBBR","CYPZI","CYPDI","FIMMI","SCIJC","SCIMU","CYPRO"," FIMSCH","FUIUMB"
            )
        val sedgesClassification = arrayOf(
            "Sedges","Sedges","Sedges","Sedges","Sedges","Sedges","Sedges","Sedges","Sedges","Sedges"
            )
        val sedgesGrowsIn = arrayOf(
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields"
            )
        val sedgesLifeCyle = arrayOf(
            "Perrenial","Perrenial","Perrenial","Perrenial","Perrenial","Perrenial","Perrenial","Perrenial","Annual","Perrenial"
            )
        val sedgesReproduction = arrayOf(
            "Seeds, Sometimes rhizomes","Seeds, Sometimes rhizomes","Seeds","Seeds","Seeds","Seeds, Sometimes rhizomes","Seeds, Sometimes rhizomes","Seeds, Sometimes rhizomes","Seeds","Seeds"
            )
        val sedgesCharacteristics = arrayOf(
            context.getString(R.string.char_acuta),
            context.getString(R.string.char_cyperus),
            context.getString(R.string.char_iria),
            context.getString(R.string.char_difformis),
            context.getString(R.string.char_milicea),
            context.getString(R.string.char_juncoides),
            context.getString(R.string.char_mucronatus),
            context.getString(R.string.char_rotundos),
            context.getString(R.string.char_schoenoides),
            context.getString(R.string.char_fuirena)
            )
        val sedgesImpact = arrayOf(
            context.getString(R.string.imp_acuta),
            context.getString(R.string.imp_cyperus),
            context.getString(R.string.imp_iria),
            context.getString(R.string.imp_difformis),
            context.getString(R.string.imp_milicea),
            context.getString(R.string.imp_juncoides),
            context.getString(R.string.imp_mucronatus),
            context.getString(R.string.imp_rotundos),
            context.getString(R.string.imp_schoenoides),
            context.getString(R.string.imp_fuirena)
            )
        for (i in 0 until sedgesImageResources.size) {
            // Check if the data already exists in the table before inserting
            if (!dbHelper.isWeedItemExist(SedgesContract.SedgesEntry.TABLE_NAME, sedgesScientificNames[i])) {
                val sedgesItem = Weed(0, sedgesImageResources[i], sedgesScientificNames[i],sedgeslocalName[i],sedgesFamily[i],sedgesEppoCode[i],sedgesClassification[i],sedgesGrowsIn[i],sedgesLifeCyle[i],sedgesReproduction[i],sedgesCharacteristics[i],sedgesImpact[i])
                dbHelper.insertWeedItem(SedgesContract.SedgesEntry.TABLE_NAME, sedgesItem)
            }
        }

        // Sample data for grass (insert 1 image at a time)
        val grassImageResources = arrayOf(
            R.drawable.grasscolona, R.drawable.grassrepens, R.drawable.grassmutica,
            R.drawable.grasschinensis, R.drawable.grassciliaris, R.drawable.grassconjugatum,
            R.drawable.grassdactylon, R.drawable.grasshexandra, R.drawable.grassindica, R.drawable.grassrugosum
        )

        val grassScientificNames = arrayOf(
            "Echinochloa colona\n(barnyard grass)", "Panicum repens\n(torpedo grass)", "Brachiaria mutica\n(para grass)",
            "Leptochloa chinensis\n(Chinese sprangletop)", "Digitaria ciliaris\n(southern crabgrass)", "Paspalum conjugatum\n(sour paspalum)",
            "Cynodon dactylon\n(Bermuda grass)", "Leersia hexandra\n(ricefield ricegrass)", "Eleusine indica\n(goosegrass) ",
            "Ischaemum rugosum\n(rugoste ischaemum)"
        )
        val grasslocalName = arrayOf(
            "Dukayang, Pulang-pwet, Ikog-iring","Tagik-tagik, buwag-buwag, murag bermuda","Para-paraan",
            " Kuring-kuring, marapagay, maroy-paroy","Baludgangan, halos, saka-saka","Lakatan, Kulape, Laau-laau",
            "Bakbaka, buku-buku","Amgid, barit","Pad-pad, Bikad-Bikad, Paragis, Parangis","Baluktot-lupa"
        )
        val grassFamily = arrayOf(
            "Poaceae","Poaceae","Poaceae","Poaceae","Poaceae","Poaceae","Poaceae","Poaceae","Poaceae","Poaceae",
        )
        val grassEppoCode = arrayOf(
            "ECHCO","PANRE","BRAMU","LEPCN","DIGCI","PASCO","CYNDT","LERHE","ELEIN","ISCRU"
        )
        val grassClassification = arrayOf(
            "Grass","Grass","Grass","Grass","Grass","Grass","Grass","Grass","Grass","Grass",
        )
        val grassGrowsIn = arrayOf(
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields s and along bunds of irrigated fields ","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "rainfed lowland ricefields","irrigated and rainfed lowland ricefields","rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields"
        )
        val grassLifeCyle = arrayOf(
            "Annual","Perrenial","Perrenial","Annual, sometimes perennial","Annual","Perrenial","Perrenial","Perrenial","Annual","Perrenial"
        )
        val grassReproduction = arrayOf(
            "Seeds, Sometimes rhizomes","and rootstock","Seeds",
            "primarily by seeds but can also propagate by culm cuttings","Seeds","seeds and stem cuttings",
            "seeds and vegetative parts (stolons and rhizomes)","Seeds and rootstocks","Seeds","Seeds"
        )
        val grassCharacteristics = arrayOf(
            context.getString(R.string.char_colona),
            context.getString(R.string.char_repens),
            context.getString(R.string.char_mutica),
            context.getString(R.string.char_chinesis),
            context.getString(R.string.char_ciliaris),
            context.getString(R.string.char_conjagatum),
            context.getString(R.string.char_dactylon),
            context.getString(R.string.char_hexandra),
            context.getString(R.string.char_eleusine_indica),
            context.getString(R.string.char_rogusom)
        )
        val grassImpact = arrayOf(
            context.getString(R.string.imp_colona),
            context.getString(R.string.imp_repens),
            context.getString(R.string.imp_mutica),
            context.getString(R.string.imp_chinesis),
            context.getString(R.string.imp_ciliaris),
            context.getString(R.string.imp_conjagatum),
            context.getString(R.string.imp_dactylon),
            context.getString(R.string.imp_hexandra),
            context.getString(R.string.imp_eleusine_indica),
            context.getString(R.string.imp_rogusom)
        )

        for (i in 0 until grassImageResources.size) {
            // Check if the data already exists in the table before inserting
            if (!dbHelper.isWeedItemExist(GrassContract.GrassEntry.TABLE_NAME, grassScientificNames[i])) {
                val grassItem = Weed(0, grassImageResources[i], grassScientificNames[i],grasslocalName[i],grassFamily[i],grassEppoCode[i],grassClassification[i],grassGrowsIn[i],grassLifeCyle[i],grassReproduction[i],grassCharacteristics[i],grassImpact[i])
                dbHelper.insertWeedItem(GrassContract.GrassEntry.TABLE_NAME, grassItem)
            }
        }

        // Sample data for broadleaves (insert 1 image at a time)
        val broadleavesImageResources = arrayOf(
            R.drawable.broadaeschynomene, R.drawable.broadalternifolius, R.drawable.broadcoccinea,
            R.drawable.broadvaginalis, R.drawable.broadpomoea, R.drawable.broadprostrata,
            R.drawable.broadoctovalvis, R.drawable.broadniruri, R.drawable.broadcrassipes, R.drawable.broadstratiotes,
            R.drawable.broadhydrocotyle
        )
        val broadleavesScientificNames = arrayOf(
            "Aeschynomene indica\n(jointed aeschynomene)", "Cyperus alternifolius\n(umbrella plant)", "Ammannia coccinea\n(red ammannia)",
            "Monochoria vaginalis\n(swamp monocharia)", "Ipomoea aquatica\n(Water Spinach)", "Eclipta prostrata\n(false daisy)",
            "Ludwigia octovalvis\n(Mexican primrose-willow)", "Phyllanthus niruri\nstonebreaker)", "Eichhornia crassipes\n(water hyacinth)",
            "Pistia stratiotes\n(Water Lettuce)","Hydrocotyle Umbellata\n(Dollar Weed)"
        )
        val broadleaveslocalName = arrayOf(
            "Tebig, tibig-tibig","Pak pak laun, Buntot-Matsing","Kamatigi,Bintog",
            "Banaybanay sa Tubig","Kangkong, tangkong","Takip Kuhol",
            "Malabato sa Tubig","Sampa-sampalukan","Lirio",
            "Luntiang Lumot","Takip-kuhol, Jahong-jahong"
        )
        val broadleavesFamily = arrayOf(
            "Fabaceae ","Cyperaceae", "Lythraceae","Pontederiaceae", "Pontederiaceae","Asteraceae", "Onagraceae","Phyllanthaceae ", "Pontederiaceae","Araceae","Araliaceae"
        )
        val broadleavesEppoCode = arrayOf(
           "AESIN","CYPAL","AMMCO","MONVA","IPOMAQ","ECLPR","LUDOC","PHYNI","EICCR","PISST","HYDUHB"
        )
        val broadleavesClassification = arrayOf(
           "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves", "BroadLeaves","BroadLeaves"
        )
        val broadleavesGrowsIn = arrayOf(
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields",
            "irrigated and rainfed lowland ricefields","irrigated and rainfed lowland ricefields"
        )
        val broadleavesLifeCyle = arrayOf(
            "Perrenial","Perrenial","Perrenial","Perrenial","Annual","Annual or Perrenial","Perrenial","Perrenial","Annual","Perrenial","Perrenial"
        )
        val broadleavesReproduction = arrayOf(
            "Seeds","Seeds","Seeds","Seeds","Seeds and stem cuttings","Seeds","Seeds","Seeds","Seeds","Seeds","Seeds"
        )
        val broadleavesCharacteristics = arrayOf(
            context.getString(R.string.char_indica),
            context.getString(R.string.char_alternifolius),
            context.getString(R.string.char_coccinea),
            context.getString(R.string.char_vaginalis),
            context.getString(R.string.char_ipomea),
            context.getString(R.string.char_prostrata),
            context.getString(R.string.char_octovalvis),
            context.getString(R.string.char_niruri),
            context.getString(R.string.char_crassipes),
            context.getString(R.string.char_stratiotes),
            context.getString(R.string.char_umbelleta)
        )
        val broadleavesImpact = arrayOf(
            context.getString(R.string.imp_indica),
            context.getString(R.string.imp_alternifolius),
            context.getString(R.string.imp_coccinea),
            context.getString(R.string.imp_vaginalis),
            context.getString(R.string.imp_ipomea),
            context.getString(R.string.imp_prostrata),
            context.getString(R.string.imp_octovalvis),
            context.getString(R.string.imp_niruri),
            context.getString(R.string.imp_crassipes),
            context.getString(R.string.imp_stratiotes),
            context.getString(R.string.imp_umbelleta)
        )

        for (i in 0 until broadleavesImageResources.size) {
            // Check if the data already exists in the table before inserting
            if (!dbHelper.isWeedItemExist(BroadleavesContract.BroadleavesEntry.TABLE_NAME, broadleavesScientificNames[i])) {
                val broadleavesItem = Weed(0, broadleavesImageResources[i], broadleavesScientificNames[i],broadleaveslocalName[i],broadleavesFamily[i],broadleavesEppoCode[i],broadleavesClassification[i],broadleavesGrowsIn[i],broadleavesLifeCyle[i],broadleavesReproduction[i],broadleavesCharacteristics[i],broadleavesImpact[i])
                dbHelper.insertWeedItem(BroadleavesContract.BroadleavesEntry.TABLE_NAME, broadleavesItem)
            }
        }
    }
}
