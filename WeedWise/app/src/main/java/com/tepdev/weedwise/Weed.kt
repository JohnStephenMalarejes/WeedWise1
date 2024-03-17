package com.tepdev.weedwise

data class Weed(
    val id: Long,
    val imageResource: Int,
    val scientificName: String,
    val localName: String,
    val family: String,
    val eppoCode: String,
    val classification: String,
    val growsIn: String,
    val lifeCycle: String,
    val reproduction: String,
    val characteristics: String,
    val impact: String
)
