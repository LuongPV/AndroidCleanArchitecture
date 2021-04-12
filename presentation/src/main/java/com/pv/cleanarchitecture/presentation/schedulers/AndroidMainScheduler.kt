package com.pv.cleanarchitecture.presentation.schedulers

import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class AndroidMainScheduler : PostExecutionScheduler {

    override fun getExecutionScheduler() = AndroidSchedulers.mainThread()!!

}