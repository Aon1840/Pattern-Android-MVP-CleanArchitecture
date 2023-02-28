package com.coin.presentation

open class BasePresenter<T : BaseView> {
    private var view: T? = null

    fun setView(view: T) {
        this.view = view
    }

    fun doInView(block: (T) -> Unit) {
        view?.let {
            block.invoke(it)
        }
    }

    fun doInView(condition: Boolean, block: (T) -> Unit) {
        if (condition) {
            view?.let {
                block.invoke(it)
            }
        }
    }
}