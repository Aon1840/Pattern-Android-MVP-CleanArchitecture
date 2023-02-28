package com.coin.domain.repository

import com.coin.domain.model.Mobile
import io.reactivex.Single

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface LandingRepositoryContractor {

    fun getPhoneList(): Single<List<Mobile>>

}