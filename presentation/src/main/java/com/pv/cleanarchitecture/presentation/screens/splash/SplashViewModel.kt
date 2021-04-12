package com.pv.cleanarchitecture.presentation.screens.splash

import com.pv.cleanarchitecture.domain.interactors.CheckLoginUseCase
import com.pv.cleanarchitecture.presentation.screens.base.BaseViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.functions.Consumer
import java.util.concurrent.TimeUnit

class SplashViewModel(
    private val checkLoginUseCase: CheckLoginUseCase
) : BaseViewModel() {
    companion object {
        private const val DELAY_SPLASH = 3000L
    }

    fun initSplash() {
        Completable.create {
            it.onComplete()
        }
        .delay(DELAY_SPLASH, TimeUnit.MILLISECONDS)
        .subscribe {
            checkLogin()
        }.add(this)
    }

    private fun checkLogin() {
        checkLoginUseCase.execute(createErrorHandler(), null, Consumer {
            if (it.isPresent) {
                uiAction.value = MoveToHome()
            } else {
                uiAction.value = MoveToLogin()
            }
        }).add(this)
    }

}