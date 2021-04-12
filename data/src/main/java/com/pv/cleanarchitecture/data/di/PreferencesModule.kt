package com.pv.cleanarchitecture.data.di

import com.pv.cleanarchitecture.data.preferences.AccountPreferences
import com.pv.cleanarchitecture.data.preferences.AccountPreferencesImpl
import org.koin.dsl.module

val preferencesModule = module {
    single<AccountPreferences> { AccountPreferencesImpl() }
}