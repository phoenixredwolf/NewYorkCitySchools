package com.phoenixredwolf.newyorkcityschools.di

import com.phoenixredwolf.newyorkcityschools.data.repository.Repository
import com.phoenixredwolf.newyorkcityschools.data.repository.RepositoryImpl
import com.phoenixredwolf.newyorkcityschools.network.SchoolApi
import com.phoenixredwolf.newyorkcityschools.network.SchoolDataService
import com.phoenixredwolf.newyorkcityschools.ui.viewmodel.MainViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {


    single {
        Retrofit.Builder()
            .client(SchoolApi.httpClient)
            .baseUrl(SchoolApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory
                .create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .build()
            .create(SchoolDataService::class.java)
    }

    single<Repository> {
        RepositoryImpl(get())
    }

    viewModel {
        MainViewModel(get())
    }
}