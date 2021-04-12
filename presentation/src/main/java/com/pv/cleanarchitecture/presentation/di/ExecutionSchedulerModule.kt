package com.pv.cleanarchitecture.presentation.di

import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import com.pv.cleanarchitecture.presentation.schedulers.AndroidMainScheduler
import com.pv.cleanarchitecture.presentation.schedulers.ComputationScheduler
import com.pv.cleanarchitecture.presentation.schedulers.IOScheduler
import com.pv.cleanarchitecture.presentation.schedulers.SchedulerName.SCHEDULER_COMPUTATION
import com.pv.cleanarchitecture.presentation.schedulers.SchedulerName.SCHEDULER_IO
import org.koin.core.qualifier.named
import org.koin.dsl.module


val executionSchedulerModule = module {

    single<OnExecutionScheduler>(named(SCHEDULER_IO)) { IOScheduler() }

    single<OnExecutionScheduler>(named(SCHEDULER_COMPUTATION)) { ComputationScheduler() }

    single<PostExecutionScheduler> { AndroidMainScheduler() }

}