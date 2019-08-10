package com.github.emilg1101.spacex.presentation.rx.transformer

import com.github.emilg1101.spacex.SpacexApp
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

class PresentationSingleTransformer<T> : SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.doOnError(Throwable::printStackTrace)
            .subscribeOn(SpacexApp.NETWORK_SCHEDULER)
            .observeOn(AndroidSchedulers.mainThread())
    }
}
