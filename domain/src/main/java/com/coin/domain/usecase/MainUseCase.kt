package com.coin.domain.usecase

import com.coin.domain.BaseSingleUseCase
import com.coin.domain.BaseUseCase
import com.coin.domain.ThreadExecutor
import com.coin.domain.ThreadExecutors
import com.coin.domain.repository.LandingRepositoryContractor
import com.coin.domain.model.Mobile
import javax.inject.Inject
import javax.inject.Named

class MainUseCase @Inject constructor(
    @Named(ThreadExecutors.SUBSCRIBER_ON_IO) subscriberOn: ThreadExecutor,
    @Named(ThreadExecutors.OBSERVER_ON) observerOn: ThreadExecutor,
    private val repository: LandingRepositoryContractor
) : BaseSingleUseCase<List<Mobile>, BaseUseCase.VoidParams>(
    subscriberOn,
    observerOn,
    builder = { repository.getPhoneList() }
)