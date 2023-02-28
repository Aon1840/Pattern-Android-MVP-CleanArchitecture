package com.coin.data.network.api

import com.coin.data.model.MobileEntity
import com.coin.data.network.service.LandingService
import io.reactivex.Single
import javax.inject.Inject

class LandingApi @Inject constructor(
        private val service: LandingService
) {
    fun getMobileList(): Single<List<MobileEntity>> {
        return service.getMobileList()
    }
}