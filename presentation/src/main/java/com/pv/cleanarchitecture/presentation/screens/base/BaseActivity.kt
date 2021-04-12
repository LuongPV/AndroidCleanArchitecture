package com.pv.cleanarchitecture.presentation.screens.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pv.cleanarchitecture.data.utils.SingleDataCallback
import com.pv.cleanarchitecture.presentation.screens.login.LoginActivity
import com.pv.cleanarchitecture.presentation.utils.DialogUtil

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let {
            setContentView(it)
        }
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        getViewModel()?.destroy()
    }

    fun listenUIAction(implementationOnCallback: SingleDataCallback<UIAction>) {
        getViewModel()?.let { baseViewModel ->
            baseViewModel.getUIAction().observe(this, Observer<UIAction> {
                if (!handleCommonUIAction(it)) {
                    implementationOnCallback(it)
                }
            })
        }
    }

    private fun handleCommonUIAction(uiAction: UIAction): Boolean {
        when (uiAction) {
            is NoInternet -> DialogUtil.showInformationDialog(this, "No internet!")
            is ConnectionTimeout -> DialogUtil.showInformationDialog(
                this,
                "Couldn't connect to server!"
            )
            is ServerIssue -> DialogUtil.showInformationDialog(
                this,
                "We got technical issue, please come back later!"
            )
            is LoginTokenExpired -> {
                startActivity(LoginActivity.getStartIntent(this))
                finishAffinity()
                DialogUtil.showInformationDialog(
                    this,
                    "Please login again to use the app!"
                )
            }
            else -> return false
        }
        return true
    }

    abstract fun initViews()

    abstract fun getLayoutId(): Int?

    abstract fun getViewModel(): BaseViewModel?

}