package com.ekar.assignment.di

import com.ekar.assignment.data.repository.CarDetailRepository
import com.ekar.assignment.domain.usecase.GetCarDetail
import com.ekar.assignment.domain.mapper.CarSpecUIModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@[Module InstallIn(ViewModelComponent::class)]
object UseCaseModule {

    @[Provides]
    fun provideCarDetailUseCase(
        repository: CarDetailRepository,
        mapper: CarSpecUIModelMapper
    ) = GetCarDetail(repository, mapper)

}