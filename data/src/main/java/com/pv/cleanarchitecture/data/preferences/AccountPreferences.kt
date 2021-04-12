package com.pv.cleanarchitecture.data.preferences

import com.pv.cleanarchitecture.domain.models.Account
import io.reactivex.rxjava3.core.Single
import java.util.*

interface AccountPreferences {

    fun getLoggedInAccount(): Single<Optional<Account>>

}