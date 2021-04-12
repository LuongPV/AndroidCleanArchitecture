package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.repositories.AccountRepository
import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single

class LogoutUseCase(
    private val accountRepository: AccountRepository,
    onExecutionScheduler: OnExecutionScheduler,
    postExecutionScheduler: PostExecutionScheduler
) : UseCase<Void, Boolean>(onExecutionScheduler, postExecutionScheduler) {

    override fun create(params: Void): Single<Boolean> {
        return accountRepository.logout()
    }

}