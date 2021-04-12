package com.pv.cleanarchitecture.data.preferences

import com.pv.cleanarchitecture.domain.models.Account
import io.reactivex.rxjava3.core.Single
import java.util.*

class AccountPreferencesImpl : AccountPreferences {

    override fun getLoggedInAccount(): Single<Optional<Account>> {
        return Single.just(Optional.of(Account("username", "password")))
    }

}