package com.pv.cleanarchitecture.presentation.di

import com.pv.cleanarchitecture.domain.interactors.CheckLoginUseCase
import com.pv.cleanarchitecture.domain.interactors.LoginUseCase
import com.pv.cleanarchitecture.presentation.schedulers.SchedulerName.SCHEDULER_IO
import org.koin.core.qualifier.named
import org.koin.dsl.module


val useCaseModule = module {

    single { CheckLoginUseCase(get(), get(named(SCHEDULER_IO)), get()) }

    single { LoginUseCase(get(), get(named(SCHEDULER_IO)), get()) }

}