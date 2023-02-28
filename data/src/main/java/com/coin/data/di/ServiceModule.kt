package com.coin.data.di

import com.coin.data.network.service.LandingService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    internal fun provideLandingService(retrofit: Retrofit): LandingService {
        return retrofit.create(LandingService::class.java)
    }
}