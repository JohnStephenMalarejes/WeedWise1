package com.tepdev.weedwise

import android.provider.BaseColumns

object SedgesContract {
    class SedgesEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "sedges"
        }
    }
}