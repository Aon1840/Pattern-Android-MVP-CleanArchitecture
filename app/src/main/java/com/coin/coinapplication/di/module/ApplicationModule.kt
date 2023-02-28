package com.coin.coinapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

}
