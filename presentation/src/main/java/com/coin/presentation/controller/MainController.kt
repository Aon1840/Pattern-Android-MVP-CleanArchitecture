package com.coin.presentation.controller

import com.coin.domain.BaseUseCase
import com.coin.domain.model.Mobile
import com.coin.domain.usecase.MainUseCase
import com.coin.presentation.BaseController
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainController
@Inject constructor(
    private val useCase: MainUseCase,
) : BaseController() {

    fun callGetPhone(
        onSuccess: (List<Mobile>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        useCase.execute(
            onSuccess,
            onError,
            BaseUseCase.VoidParams(),
            CompositeDisposable()
        )
    }

//    fun callGetPhoneCache(
//        onSuccess: (List<Mobile>) -> Unit,
//        onError: (Throwable) -> Unit
//    ) {
//        getDataBaseUseCase.execute(
//            onSuccess,
//            onError,
//            BaseUseCase.VoidParams(),
//            CompositeDisposable()
//        )
//    }
//
//    fun insertPhoneCache(
//        request: List<Mobile>,
//        onSuccess: () -> Unit,
//        onError: (Throwable) -> Unit
//    ) {
//        insertDataBaseUseCase.execute(
//            onSuccess,
//            onError,
//            InsertDataBaseUseCase.Param(request),
//            CompositeDisposable()
//        )
//    }

}