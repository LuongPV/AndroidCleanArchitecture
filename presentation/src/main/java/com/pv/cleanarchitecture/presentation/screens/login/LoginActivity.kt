package com.pv.cleanarchitecture.presentation.screens.login

import android.content.Context
import android.content.Intent
import com.pv.cleanarchitecture.R
import com.pv.cleanarchitecture.presentation.screens.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {
    companion object {
        fun getStartIntent(context: Context) = Intent(
            context, LoginActivity::class.java
        )
    }
    private val loginViewModel: LoginViewModel by viewModel()

    override fun getViewModel() = loginViewModel

    override fun getLayoutId() = R.layout.activity_login

    override fun initViews() {
        listenUIAction {

        }
        btnLogin.setOnClickListener {
            loginViewModel.login(etUsername.text.toString(), etPassword.text.toString())
        }
    }

}