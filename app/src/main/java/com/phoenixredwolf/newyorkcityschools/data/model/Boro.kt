package com.phoenixredwolf.newyorkcityschools.data.model

import com.phoenixredwolf.newyorkcityschools.data.model.Boro.*

enum class Boro(
    val boroName: String
) {
    BROOKLYN("K"),
    BRONX("X"),
    MANHATTAN("M"),
    QUEENS("Q"),
    STATEN_ISLAND("R"),
    SELECT_BORO("")
}

fun getAllBoros():List<Boro>{
    return listOf(
        SELECT_BORO,
        BROOKLYN,
        BRONX,
        MANHATTAN,
        QUEENS,
        STATEN_ISLAND
    )
}

fun getBoro(boro: String) : Boro? {
    val map = values().associateBy(Boro::boroName)
    return map[boro]
}