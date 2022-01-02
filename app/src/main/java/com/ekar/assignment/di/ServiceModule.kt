package com.ekar.assignment.di

import com.ekar.assignment.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

@[Module InstallIn(SingletonComponent::class)]
object ServiceModule {

    @[Provides]
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}