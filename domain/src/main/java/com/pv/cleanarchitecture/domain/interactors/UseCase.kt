package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer

abstract class UseCase<ParamType, DataType>(
    private val onExecutionScheduler: OnExecutionScheduler,
    private val postExecutionScheduler: PostExecutionScheduler
) {

    fun execute(onError: Consumer<Throwable>, params: ParamType, onSuccess: Consumer<DataType>? = null): Disposable {
        val task = create(params)
        return task.subscribeOn(onExecutionScheduler.getExecutionScheduler())
            .observeOn(postExecutionScheduler.getExecutionScheduler())
            .subscribe({
                onSuccess?.accept(it)
            }, {
                onError.accept(it)
            })
    }

    abstract fun create(params: ParamType): Single<DataType>

}