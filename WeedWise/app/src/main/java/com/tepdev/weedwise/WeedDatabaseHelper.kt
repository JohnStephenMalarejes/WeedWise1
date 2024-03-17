// WeedDatabaseHelper.kt
package com.tepdev.weedwise

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class WeedDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "weed.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create tables for each type (sedges, grass, broadleaves)
        createTable(db, SedgesContract.SedgesEntry.TABLE_NAME)
        createTable(db, GrassContract.GrassEntry.TABLE_NAME)
        createTable(db, BroadleavesContract.BroadleavesEntry.TABLE_NAME)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrade (e.g., drop and recreate tables)
        db.execSQL("DROP TABLE IF EXISTS ${SedgesContract.SedgesEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${GrassContract.GrassEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${BroadleavesContract.BroadleavesEntry.TABLE_NAME}")
        onCreate(db)
    }

    private fun createTable(db: SQLiteDatabase, tableName: String) {
        val createTableSQL = """
            CREATE TABLE $tableName (
                ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${ImageContract.ImageEntry.COLUMN_IMAGE_RESOURCE} INTEGER,
                ${ImageContract.ImageEntry.COLUMN_SCIENTIFIC_NAME} TEXT,
                ${ImageContract.ImageEntry.COLUMN_LOCAL_NAME} TEXT,
                ${ImageContract.ImageEntry.COLUMN_FAMILY_NAME} TEXT,
                ${ImageContract.ImageEntry.COLUMN_EPPO_CODE} TEXT,
                ${ImageContract.ImageEntry.COLUMN_CLASSIFICATION} TEXT,
                ${ImageContract.ImageEntry.COLUMN_GROWS_IN} TEXT,
                ${ImageContract.ImageEntry.COLUMN_LIFE_CYCLE} TEXT,
                ${ImageContract.ImageEntry.COLUMN_REPRODUCTION} TEXT,
                ${ImageContract.ImageEntry.COLUMN_CHARACTERISTIC} TEXT,
                ${ImageContract.ImageEntry.COLUMN_IMPACT} TEXT
            )
        """
        db.execSQL(createTableSQL)
    }

    fun insertWeedItem(tableName: String, item: Weed) {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(ImageContract.ImageEntry.COLUMN_IMAGE_RESOURCE, item.imageResource)
            put(ImageContract.ImageEntry.COLUMN_SCIENTIFIC_NAME, item.scientificName)
            put(ImageContract.ImageEntry.COLUMN_LOCAL_NAME, item.localName)
            put(ImageContract.ImageEntry.COLUMN_FAMILY_NAME, item.family)
            put(ImageContract.ImageEntry.COLUMN_EPPO_CODE, item.eppoCode)
            put(ImageContract.ImageEntry.COLUMN_CLASSIFICATION, item.classification)
            put(ImageContract.ImageEntry.COLUMN_GROWS_IN, item.growsIn)
            put(ImageContract.ImageEntry.COLUMN_LIFE_CYCLE, item.lifeCycle)
            put(ImageContract.ImageEntry.COLUMN_REPRODUCTION, item.reproduction)
            put(ImageContract.ImageEntry.COLUMN_CHARACTERISTIC, item.characteristics)
            put(ImageContract.ImageEntry.COLUMN_IMPACT, item.impact)
        }

        db.insert(tableName, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllWeedsFromTable(tableName: String): List<Weed> {
        val weeds = mutableListOf<Weed>()
        val db = readableDatabase

        val projection = arrayOf(
            BaseColumns._ID,
            ImageContract.ImageEntry.COLUMN_IMAGE_RESOURCE,
            ImageContract.ImageEntry.COLUMN_SCIENTIFIC_NAME,
            ImageContract.ImageEntry.COLUMN_LOCAL_NAME,
            ImageContract.ImageEntry.COLUMN_FAMILY_NAME,
            ImageContract.ImageEntry.COLUMN_EPPO_CODE,
            ImageContract.ImageEntry.COLUMN_CLASSIFICATION,
            ImageContract.ImageEntry.COLUMN_GROWS_IN,
            ImageContract.ImageEntry.COLUMN_LIFE_CYCLE,
            ImageContract.ImageEntry.COLUMN_REPRODUCTION,
            ImageContract.ImageEntry.COLUMN_CHARACTERISTIC,
            ImageContract.ImageEntry.COLUMN_IMPACT
        )

        val cursor: Cursor = db.query(
            tableName,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID))
            val imageResource = cursor.getInt(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_IMAGE_RESOURCE))
            val scientificName = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_SCIENTIFIC_NAME))
            val localName = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_LOCAL_NAME))
            val familyName = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_FAMILY_NAME))
            val eppoCode = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_EPPO_CODE))
            val classification = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_CLASSIFICATION))
            val growsIn = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_GROWS_IN))
            val lifeCycle = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_LIFE_CYCLE))
            val reproduction = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_REPRODUCTION))
            val characteristics = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_CHARACTERISTIC))
            val impact = cursor.getString(cursor.getColumnIndex(ImageContract.ImageEntry.COLUMN_IMPACT))

            val weed = Weed(id, imageResource, scientificName, localName, familyName, eppoCode, classification, growsIn, lifeCycle, reproduction, characteristics, impact)
            weeds.add(weed)
        }

        cursor.close()
        db.close()

        return weeds
    }

    fun isWeedItemExist(tableName: String, scientificName: String): Boolean {
        val db = readableDatabase
        val selection = "${ImageContract.ImageEntry.COLUMN_SCIENTIFIC_NAME} = ?"
        val selectionArgs = arrayOf(scientificName)

        val cursor = db.query(
            tableName,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        val itemExists = cursor.count > 0

        cursor.close()
        db.close()

        return itemExists
    }
}

