package com.ekar.assignment.core.domain

import kotlinx.coroutines.flow.Flow

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
interface UseCaseWithFlow<in Input, out Output> {
    suspend operator fun invoke(input: Input): Flow<Output>
}

interface NoInputUseCaseWithFlow<out Output> {
    suspend operator fun invoke(): Flow<Output>
}
