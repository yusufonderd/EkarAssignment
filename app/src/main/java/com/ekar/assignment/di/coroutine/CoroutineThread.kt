package com.ekar.assignment.di.coroutine

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
interface CoroutineThread {
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}
