package com.phoenixredwolf.newyorkcityschools

import android.app.Application
import com.phoenixredwolf.newyorkcityschools.data.repository.Repository
import com.phoenixredwolf.newyorkcityschools.network.SchoolApi.retrofitService
import com.phoenixredwolf.newyorkcityschools.network.SchoolDataManager

class App : Application() {

    private val manager by lazy {
        SchoolDataManager(retrofitService)
    }

    val repository by lazy {
        Repository(manager)
    }
}