package com.pv.cleanarchitecture.data.apis

import com.pv.cleanarchitecture.domain.models.Account
import io.reactivex.rxjava3.core.Single

interface AccountAPI {

    fun login(account: Account): Single<Boolean>

    fun logout(): Single<Boolean>

}