package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.models.Account
import com.pv.cleanarchitecture.domain.repositories.AccountRepository
import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single
import java.util.*

class CheckLoginUseCase(
    private val accountRepository: AccountRepository,
    onExecutionScheduler: OnExecutionScheduler,
    postExecutionScheduler: PostExecutionScheduler
) : UseCase<Void?, Optional<Account>>(onExecutionScheduler, postExecutionScheduler) {

    override fun create(params: Void?): Single<Optional<Account>> {
        return accountRepository.getLoggedInAccount()
    }

}