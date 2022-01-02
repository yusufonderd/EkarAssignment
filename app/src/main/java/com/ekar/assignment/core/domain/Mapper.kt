package com.ekar.assignment.core.domain

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
interface Mapper <in Input, out Output> {
    fun map(input: Input): Output
}