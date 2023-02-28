package com.coin.coinapplication.di.module

import com.coin.domain.ThreadExecutor
import com.coin.domain.ThreadExecutors
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    @Named(ThreadExecutors.SUBSCRIBER_ON_IO)
    internal fun provideSubscriberOnIOThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.io())
    }

    @Provides
    @Singleton
    @Named(ThreadExecutors.OBSERVER_ON)
    internal fun provideObserverOnExecutionThread(): ThreadExecutor {
        return ThreadExecutor(AndroidSchedulers.mainThread())
    }

}