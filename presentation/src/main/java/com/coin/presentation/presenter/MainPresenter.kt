package com.coin.presentation.presenter

import com.coin.presentation.controller.MainController
import com.coin.presentation.view.MainContractor
import com.coin.presentation.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val controller: MainController
) : BasePresenter<MainContractor.View>(), MainContractor.Presenter {

    override fun onStart() {
        controller.callGetPhone(
            {
                doInView { view -> view.displayText("Call phone list success::") }
            },
            {
                doInView { view -> view.displayText("Exception::") }
            }
        )
    }

}