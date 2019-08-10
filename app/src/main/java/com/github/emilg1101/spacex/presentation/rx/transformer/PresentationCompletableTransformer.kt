package com.github.emilg1101.spacex.presentation.rx.transformer

import com.github.emilg1101.spacex.SpacexApp.Companion.NETWORK_SCHEDULER
import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.CompletableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

class PresentationCompletableTransformer : CompletableTransformer {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream.doOnError(Throwable::printStackTrace)
            .subscribeOn(NETWORK_SCHEDULER)
            .observeOn(AndroidSchedulers.mainThread())
    }
}
