package com.pv.cleanarchitecture.presentation.schedulers

import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class IOScheduler : OnExecutionScheduler {

    override fun getExecutionScheduler() = Schedulers.io()!!

}