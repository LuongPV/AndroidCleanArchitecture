package com.pv.cleanarchitecture.presentation.screens.base

import androidx.lifecycle.MutableLiveData
import com.pv.cleanarchitecture.data.exceptions.ConnectionTimeoutException
import com.pv.cleanarchitecture.data.exceptions.LoginExpiredException
import com.pv.cleanarchitecture.data.exceptions.NoInternetException
import com.pv.cleanarchitecture.data.exceptions.ServerIssueException
import com.pv.cleanarchitecture.data.utils.SingleDataCallback
import io.reactivex.rxjava3.functions.Consumer

class CommonExceptionConsumer(
    private val uiAction: MutableLiveData<UIAction>,
    private val outBoundExceptionHandler: SingleDataCallback<Throwable>?
) : Consumer<Throwable> {

    override fun accept(throwable: Throwable) {
        when (throwable) {
            is NoInternetException -> uiAction.value = NoInternet()
            is ConnectionTimeoutException -> uiAction.value = ConnectionTimeout()
            is ServerIssueException -> uiAction.value = ServerIssue()
            is LoginExpiredException -> uiAction.value = LoginTokenExpired()
            else -> {
                outBoundExceptionHandler?.invoke(throwable) ?: run {
                    uiAction.value = ServerIssue()
                }
            }
        }
    }

}