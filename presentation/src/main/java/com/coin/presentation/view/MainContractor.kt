package com.coin.presentation.view

import com.coin.presentation.BaseView

interface MainContractor {

    interface View : BaseView {
        fun displayText(text: String)
    }

    interface Presenter {
        fun onStart()
    }
}