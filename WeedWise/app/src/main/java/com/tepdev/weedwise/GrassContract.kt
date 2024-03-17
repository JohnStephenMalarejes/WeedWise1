package com.tepdev.weedwise

import android.provider.BaseColumns

object GrassContract {
    class GrassEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "grass"
        }
    }
}