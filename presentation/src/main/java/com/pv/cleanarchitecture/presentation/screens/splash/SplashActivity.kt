package com.pv.cleanarchitecture.presentation.screens.splash

import com.pv.cleanarchitecture.R
import com.pv.cleanarchitecture.presentation.screens.base.BaseActivity
import com.pv.cleanarchitecture.presentation.screens.home.HomeActivity
import com.pv.cleanarchitecture.presentation.screens.login.LoginActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {
    private val splashViewModel: SplashViewModel by viewModel()

    override fun getViewModel() = splashViewModel

    override fun getLayoutId() = R.layout.activity_splash

    override fun initViews() {
        listenUIAction {
            when (it) {
                is MoveToHome -> startActivity(HomeActivity.getStartIntent(this))
                is MoveToLogin -> startActivity(LoginActivity.getStartIntent(this))
            }
        }
        splashViewModel.initSplash()
    }

}