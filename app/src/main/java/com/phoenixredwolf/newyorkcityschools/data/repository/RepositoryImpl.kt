package com.phoenixredwolf.newyorkcityschools.data.repository

import com.phoenixredwolf.newyorkcityschools.network.SchoolDataService

class RepositoryImpl(private val manager: SchoolDataService): Repository {
    override suspend fun getAllSchools() = manager.getAllSchools()
    override suspend fun getBoroSchools(boro:String) = manager.getBoroSchools(boro)
    override suspend fun getNeighborhoodSchools(neighborhood:String) = manager.getNeighborhoodSchools(neighborhood)
    override suspend fun getSchoolsWithLanguage(language:String) = manager.getSchoolsWithLanguage(language)
    override suspend fun getSatScoresForSchool(dbn: String) = manager.getSatForSchool(dbn)

}