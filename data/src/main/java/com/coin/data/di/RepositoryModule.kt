package com.coin.data.di

import com.coin.data.mapper.LandingMapper
import com.coin.data.network.api.LandingApi
import com.coin.data.repository.LandingRepository
import com.coin.domain.repository.LandingRepositoryContractor
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    internal fun provideLandingRepository(
        api: LandingApi,
        mapper: LandingMapper
    ): LandingRepositoryContractor {
        return LandingRepository(api, mapper)
    }
}