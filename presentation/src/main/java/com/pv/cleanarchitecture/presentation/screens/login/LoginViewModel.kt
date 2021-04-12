package com.pv.cleanarchitecture.presentation.screens.login

import com.pv.cleanarchitecture.domain.interactors.LoginUseCase
import com.pv.cleanarchitecture.domain.models.Account
import com.pv.cleanarchitecture.presentation.screens.base.BaseViewModel
import io.reactivex.rxjava3.functions.Consumer
import retrofit2.HttpException
import java.net.HttpURLConnection

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    fun login(username: String, password: String) {
        when {
            username.trim().isEmpty() -> uiAction.value = ValidationFailUsernameEmpty()
            password.trim().isEmpty() -> uiAction.value = ValidationFailPasswordEmpty()
        }
        loginUseCase.execute(createErrorHandler {
            if (it is HttpException && it.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                uiAction.value = LoginFail()
            }
        }, Account(username, password), Consumer {
            uiAction.value = if (it) LoginSuccess() else LoginFail()
        }).add(this)
    }

}