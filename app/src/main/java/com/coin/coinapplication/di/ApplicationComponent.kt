package com.coin.coinapplication.di

import android.app.Application
import com.coin.coinapplication.AndroidApplication
import com.coin.coinapplication.di.module.ActivityBuilder
import com.coin.coinapplication.di.module.AndroidModule
import com.coin.coinapplication.di.module.ApplicationModule
import com.coin.coinapplication.di.module.FragmentBuilder
import com.coin.data.di.DataModule
import com.coin.data.di.NetworkModule
import com.coin.data.di.RepositoryModule
import com.coin.data.di.ServiceModule
import com.coin.domain.di.DomainModule
import com.coin.domain.di.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [
        ActivityBuilder::class,
        FragmentBuilder::class,
        ApplicationModule::class,
        AndroidModule::class,
        DomainModule::class,
        DataModule::class,
        RepositoryModule::class,
        ServiceModule::class,
        NetworkModule::class,
        UseCaseModule::class,
        AndroidSupportInjectionModule::class,
    ]
)

@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: AndroidApplication)
}
