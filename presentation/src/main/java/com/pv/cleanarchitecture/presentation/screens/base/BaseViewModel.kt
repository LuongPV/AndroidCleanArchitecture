package com.pv.cleanarchitecture.presentation.screens.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pv.cleanarchitecture.data.utils.SingleDataCallback
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel(), CompositeDisposer {
    protected val uiAction = MutableLiveData<UIAction>()
    private val compositeDisposable = CompositeDisposable()

    protected fun createErrorHandler(outBoundExceptionHandler: SingleDataCallback<Throwable>? = null) =
        CommonExceptionConsumer(uiAction, outBoundExceptionHandler)

    override fun getCompositeDisposable() = compositeDisposable

    fun getUIAction(): LiveData<UIAction> = uiAction

    fun Disposable.add(compositeDisposer: CompositeDisposer) {
        compositeDisposer.getCompositeDisposable().add(this)
    }

    fun destroy() {
        compositeDisposable.dispose()
    }
}