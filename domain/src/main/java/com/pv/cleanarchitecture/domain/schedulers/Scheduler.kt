package com.pv.cleanarchitecture.domain.schedulers

import io.reactivex.rxjava3.core.Scheduler

interface Scheduler {

    fun getExecutionScheduler(): Scheduler

}