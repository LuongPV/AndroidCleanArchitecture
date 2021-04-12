package com.pv.cleanarchitecture.presentation.screens.base

import io.reactivex.rxjava3.disposables.CompositeDisposable

interface CompositeDisposer {

    fun getCompositeDisposable(): CompositeDisposable

}