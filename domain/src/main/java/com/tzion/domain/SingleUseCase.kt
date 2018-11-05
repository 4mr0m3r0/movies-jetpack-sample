package com.tzion.domain

import com.tzion.domain.executor.PostExecutionThread
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null) {
        val single = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler) as Single<T>
        addDisposable(single.subscribeWith(singleObserver))
    }

    private fun addDisposable(disposable: Disposable) {
        if (!disposable.isDisposed) disposables.add(disposable)
    }

    fun dispose() {
        disposables.dispose()
    }

}