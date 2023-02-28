package com.coin.domain

import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable

object ThreadExecutors {
    const val SUBSCRIBER_ON_IO = "subscriberOnIO"
    const val OBSERVER_ON = "observerOn"
}

sealed class BaseUseCase(
        protected val subscriberOn: ThreadExecutor,
        protected val observerOn: ThreadExecutor
) {

    interface Params

    class VoidParams : Params
}

open class BaseSingleUseCase<R, in P : BaseUseCase.Params>(
        subscriberOn: ThreadExecutor,
        observerOn: ThreadExecutor,
        private val builder: (P) -> Single<R>
) : BaseUseCase(subscriberOn, observerOn) {

    fun execute(
            observer: SingleObserver<R>,
            params: P,
            compositeDisposable: CompositeDisposable
    ) {
        builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .observeOn(observerOn.scheduler)
                .doOnSubscribe { compositeDisposable.add(it) }
                .subscribe(observer)
    }

    fun <D> execute(
            observer: SingleObserver<D>,
            params: P,
            transform: (R) -> D,
            compositeDisposable: CompositeDisposable
    ) {
        builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .map(transform)
                .observeOn(observerOn.scheduler)
                .doOnSubscribe { compositeDisposable.add(it) }
                .subscribe(observer)
    }

    fun execute(
            onSuccess: (R) -> Unit,
            onError: (Throwable) -> Unit,
            params: P,
            compositeDisposable: CompositeDisposable
    ) {
        compositeDisposable.add(builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .observeOn(observerOn.scheduler)
                .subscribe(onSuccess, onError))
    }

    fun <D> execute(
            onSuccess: (D) -> Unit,
            onError: (Throwable) -> Unit,
            params: P,
            transform: (R) -> D,
            compositeDisposable: CompositeDisposable
    ) {
        compositeDisposable.add(builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .map(transform)
                .observeOn(observerOn.scheduler)
                .subscribe(onSuccess, onError))
    }
}

open class BaseCompletableUseCase<in P : BaseUseCase.Params>(
        subscriberOn: ThreadExecutor,
        observerOn: ThreadExecutor,
        private val builder: (P) -> Completable
) : BaseUseCase(subscriberOn, observerOn) {

    fun execute(
            observer: CompletableObserver,
            params: P,
            compositeDisposable: CompositeDisposable
    ) {
        builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .observeOn(observerOn.scheduler)
                .doOnSubscribe { compositeDisposable.add(it) }
                .subscribe(observer)
    }

    fun execute(
            onComplete: () -> Unit,
            onError: (Throwable) -> Unit,
            params: P,
            compositeDisposable: CompositeDisposable
    ) {
        compositeDisposable.add(builder(params)
                .subscribeOn(subscriberOn.scheduler)
                .observeOn(observerOn.scheduler)
                .subscribe(onComplete, onError))
    }
}
