package com.coin.presentation

import com.coin.domain.BaseCompletableUseCase
import com.coin.domain.BaseSingleUseCase
import com.coin.domain.BaseUseCase
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable

open class BaseController(private val disposables: CompositeDisposable = CompositeDisposable()) {

    open fun dispose() {
        disposables.dispose()
    }

    open fun clear() {
        disposables.clear()
    }

    fun <R, P : BaseUseCase.Params> execute(
        useCase: BaseSingleUseCase<R, P>,
        observer: SingleObserver<R>,
        params: P
    ) {
        useCase.execute(observer, params, disposables)
    }

    fun <R, P : BaseUseCase.Params> execute(
            useCase: BaseSingleUseCase<R, P>,
            onSuccess: (R) -> Unit,
            onError: (Throwable) -> Unit,
            params: P
    ) {
        useCase.execute(onSuccess, onError, params, disposables)
    }

    fun <R, P : BaseUseCase.Params, D> execute(
            useCase: BaseSingleUseCase<R, P>,
            observer: SingleObserver<D>,
            params: P,
            transform: (R) -> D
    ) {
        useCase.execute(observer, params, transform, disposables)
    }

    fun <R, P : BaseUseCase.Params, D> execute(
            useCase: BaseSingleUseCase<R, P>,
            onSuccess: (D) -> Unit,
            onError: (Throwable) -> Unit,
            params: P,
            transform: (R) -> D
    ) {
        useCase.execute(onSuccess, onError, params, transform, disposables)
    }

    fun <P : BaseUseCase.Params> execute(
            useCase: BaseCompletableUseCase<P>,
            observer: CompletableObserver,
            params: P
    ) {
        useCase.execute(observer, params, disposables)
    }

    fun <P : BaseUseCase.Params> execute(
        useCase: BaseCompletableUseCase<P>,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit,
        params: P
    ) {
        useCase.execute(onComplete, onError, params, disposables)
    }
}

