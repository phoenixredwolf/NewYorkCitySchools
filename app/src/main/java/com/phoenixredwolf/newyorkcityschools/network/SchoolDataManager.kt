package com.phoenixredwolf.newyorkcityschools.network

import com.phoenixredwolf.newyorkcityschools.data.model.SatScore
import com.phoenixredwolf.newyorkcityschools.data.model.School
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolDataManager(
    private val service: SchoolDataService
) {

    suspend fun getAllSchools(): List<School> = withContext(Dispatchers.IO) {
        service.getAllSchools()
    }

    suspend fun getBoroSchools(boro: String): List<School> = withContext(Dispatchers.IO){
        service.getBoroSchools(boro)
    }

    suspend fun getNeighborhoodSchools(neighborhood: String): List<School> = withContext(Dispatchers.IO){
        service.getNeighborhoodSchools(neighborhood)
    }

    suspend fun getSchoolsWithLanguage(language: String): List<School> = withContext(Dispatchers.IO){
        service.getSchoolsWithLanguage(language)
    }

    suspend fun getSatForSchool(dbn: String): List<SatScore> = withContext(Dispatchers.IO) {
        service.getSATForSchool(dbn)
    }
}