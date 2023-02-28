package com.coin.data.network.service

import com.coin.data.model.MobileEntity
import io.reactivex.Single
import retrofit2.http.GET

interface LandingService {
    @GET("api/mobiles/")
    fun getMobileList(): Single<List<MobileEntity>>

}