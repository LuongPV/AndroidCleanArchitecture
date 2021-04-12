package com.pv.cleanarchitecture.data.apis

import com.pv.cleanarchitecture.domain.models.Account
import io.reactivex.rxjava3.core.Single

class AccountAPIImpl : AccountAPI {

    override fun login(account: Account): Single<Boolean> {
        return Single.just(account.username == "username" && account.password == "password")
    }

    override fun logout(): Single<Boolean> {
        return Single.just(true)
    }

}