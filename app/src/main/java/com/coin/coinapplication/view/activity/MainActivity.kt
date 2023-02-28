package com.coin.coinapplication.view.activity

import android.os.Bundle
import com.coin.coinapplication.R
import com.coin.presentation.presenter.MainPresenter
import com.coin.presentation.view.MainContractor
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContractor.View {
    @Inject
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        presenter.onStart()
    }

    override fun displayText(text: String) {

    }
}