package com.ekar.assignment.di

import com.ekar.assignment.data.api.ApiService
import com.ekar.assignment.data.repository.CarDetailRepository
import com.ekar.assignment.di.coroutine.CoroutineThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @[Provides]
    fun provideCarDetailRepository(
        apiService: ApiService,
        coroutineThread: CoroutineThread
    ) = CarDetailRepository(apiService, coroutineThread)

}