package com.ekar.assignment.di.coroutine

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@InstallIn(SingletonComponent::class)
@Module
interface CoroutineModule {

    @get:[Binds Singleton]
    val CoroutineThreadImpl.coroutineThread: CoroutineThread
}
