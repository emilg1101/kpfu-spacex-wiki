package com.github.emilg1101.spacex.data.spacexapi.request

import com.github.emilg1101.spacex.data.spacexapi.pojo.response.HistoricalEvent
import io.reactivex.*

class SpaceXApiRequestDecorator(private val api: SpaceXApiRequest) : SpaceXApiRequest {

    companion object {
        private fun processApiThrowable(t: Throwable): Throwable {
            return t
        }
    }

    private class SpaceXApiRequestErrorSingleTransformer<T> : SingleTransformer<T, T> {
        override fun apply(upstream: Single<T>): SingleSource<T> {
            return upstream.onErrorResumeNext { t: Throwable ->
                Single.error(processApiThrowable(t))
            }
        }
    }

    private class SpaceXApiRequestErrorObservableTransformer<T> : ObservableTransformer<T, T> {
        override fun apply(upstream: Observable<T>): ObservableSource<T> {
            return upstream.onErrorResumeNext { t: Throwable ->
                Observable.error(processApiThrowable(t))
            }
        }
    }

    private class SpaceXApiRequestErrorCompletableTransformer : CompletableTransformer {
        override fun apply(upstream: Completable): CompletableSource {
            return upstream.onErrorResumeNext { t: Throwable ->
                Completable.error(processApiThrowable(t))
            }
        }
    }

    override fun getAllHistoricalEvents(): Single<List<HistoricalEvent>> {
        return api.getAllHistoricalEvents()
    }
}
