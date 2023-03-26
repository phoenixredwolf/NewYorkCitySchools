package com.phoenixredwolf.newyorkcityschools.network

import com.phoenixredwolf.newyorkcityschools.data.model.SatScore
import com.phoenixredwolf.newyorkcityschools.data.model.School
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolDataService {

    @GET("s3k6-pzi2.json")
    suspend fun getAllSchools(
//        @Query("\$limit") limit: Int = 5
    ) : List<School>

    @GET("s3k6-pzi2.json")
    suspend fun getBoroSchools(
        @Query("boro") boro: String
    ) : List<School>

    @GET("s3k6-pzi2.json")
    suspend fun getNeighborhoodSchools(
        @Query("neighborhood") neighborhood: String
    ) : List<School>

    @GET("s3k6-pzi2.json")
    suspend fun getSchoolsWithLanguage(
        @Query("language_classes") language: String
    ) : List<School>

    @GET("f9bf-2cp4.json")
    suspend fun getSATForSchool(
        @Query("dbn") dbn: String
    ) : List<SatScore>

}