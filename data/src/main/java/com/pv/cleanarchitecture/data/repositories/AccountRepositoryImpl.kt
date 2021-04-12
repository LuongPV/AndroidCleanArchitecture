package com.pv.cleanarchitecture.data.repositories

import com.pv.cleanarchitecture.data.apis.AccountAPI
import com.pv.cleanarchitecture.data.preferences.AccountPreferences
import com.pv.cleanarchitecture.data.utils.networkException
import com.pv.cleanarchitecture.domain.models.Account
import com.pv.cleanarchitecture.domain.repositories.AccountRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

class AccountRepositoryImpl(
    private val accountAPI: AccountAPI,
    private val accountPreferences: AccountPreferences
) : AccountRepository {

    override fun login(account: Account): Single<Boolean> {
        return accountAPI.login(account).compose(networkException())
    }

    override fun getLoggedInAccount(): Single<Optional<Account>> {
        return accountPreferences.getLoggedInAccount().compose(networkException())
    }

    override fun logout(): Single<Boolean> {
        return accountAPI.logout().compose(networkException())
    }
}