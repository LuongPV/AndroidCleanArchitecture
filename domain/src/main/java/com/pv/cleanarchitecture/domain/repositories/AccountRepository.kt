package com.pv.cleanarchitecture.domain.repositories

import com.pv.cleanarchitecture.domain.models.Account
import io.reactivex.rxjava3.core.Single
import java.util.*

interface AccountRepository {

    fun login(account: Account): Single<Boolean>

    fun getLoggedInAccount(): Single<Optional<Account>>

    fun logout(): Single<Boolean>

}