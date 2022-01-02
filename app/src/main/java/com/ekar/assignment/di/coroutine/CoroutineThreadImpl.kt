package com.ekar.assignment.di.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
class CoroutineThreadImpl @Inject constructor() : CoroutineThread {
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}
