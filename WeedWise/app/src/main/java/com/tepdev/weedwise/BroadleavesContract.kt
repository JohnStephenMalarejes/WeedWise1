package com.tepdev.weedwise

import android.provider.BaseColumns

object BroadleavesContract {
    class BroadleavesEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "broadleaves"
        }
    }
}