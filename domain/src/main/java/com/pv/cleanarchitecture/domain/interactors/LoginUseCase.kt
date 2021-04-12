package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.models.Account
import com.pv.cleanarchitecture.domain.repositories.AccountRepository
import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single

class LoginUseCase(
    private val accountRepository: AccountRepository,
    onExecutionScheduler: OnExecutionScheduler,
    postExecutionScheduler: PostExecutionScheduler
) : UseCase<Account, Boolean>(onExecutionScheduler, postExecutionScheduler) {

    override fun create(params: Account): Single<Boolean> {
        return accountRepository.login(params)
    }

}