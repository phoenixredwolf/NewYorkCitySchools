package com.phoenixredwolf.newyorkcityschools.data.repository

import com.phoenixredwolf.newyorkcityschools.data.model.SatScore
import com.phoenixredwolf.newyorkcityschools.data.model.School

interface Repository {
    suspend fun getAllSchools(): List<School>
    suspend fun getBoroSchools(boro:String): List<School>
    suspend fun getNeighborhoodSchools(neighborhood:String): List<School>
    suspend fun getSchoolsWithLanguage(language:String): List<School>
    suspend fun getSatScoresForSchool(dbn:String): List<SatScore>

}