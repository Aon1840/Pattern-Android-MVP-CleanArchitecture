package com.coin.data.mapper

import com.coin.data.model.MobileEntity
import com.coin.domain.model.Mobile
import javax.inject.Inject

class LandingMapper @Inject constructor() {

    fun transformMobile(data: List<MobileEntity>): List<Mobile> {
        return data.map {
            Mobile().apply {
                this.brand = it.brand
                this.thumbImageURL = it.thumbImageURL
                this.price = it.price
                this.name = it.name
                this.rating = it.rating
                this.id = it.id
                this.description = it.description
            }
        }
    }

}