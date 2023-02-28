package com.coin.data.repository

import com.coin.data.mapper.LandingMapper
import com.coin.data.network.api.LandingApi
import com.coin.domain.model.Mobile
import com.coin.domain.repository.LandingRepositoryContractor
import io.reactivex.Single
import javax.inject.Inject

class LandingRepository @Inject constructor(
    private val api: LandingApi,
    private val mapper: LandingMapper
) : LandingRepositoryContractor {

    override fun getPhoneList(): Single<List<Mobile>> {
        return api.getMobileList().map {
            mapper.transformMobile(it)
        }
    }

}