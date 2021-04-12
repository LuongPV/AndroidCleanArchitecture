package com.pv.cleanarchitecture.presentation

import android.app.Application
import com.pv.cleanarchitecture.BuildConfig
import com.pv.cleanarchitecture.data.di.apiModule
import com.pv.cleanarchitecture.data.di.netModule
import com.pv.cleanarchitecture.data.di.preferencesModule
import com.pv.cleanarchitecture.data.di.repositoryModule
import com.pv.cleanarchitecture.presentation.di.executionSchedulerModule
import com.pv.cleanarchitecture.presentation.di.useCaseModule
import com.pv.cleanarchitecture.presentation.di.viewModelModule
import com.pv.cleanarchitecture.presentation.logger.ReleaseTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initDI()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun initDI() {
        Timber.d("initDI")
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(preferencesModule, netModule, repositoryModule, apiModule, viewModelModule, executionSchedulerModule, useCaseModule)
        }
    }

}