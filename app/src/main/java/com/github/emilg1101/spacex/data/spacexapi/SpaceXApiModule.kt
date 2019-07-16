package com.github.emilg1101.spacex.data.spacexapi

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequest
import com.github.emilg1101.spacex.data.spacexapi.request.SpaceXApiRequestDecorator
import javax.inject.Singleton

@Module
class SpaceXApiModule {

    companion object {
        private const val BASE_URL = "https://api.spacexdata.com/v3/"
    }

    @Provides
    @Singleton
    fun provideApiRequest(@SpaceXApiQualifier okHttpClient: OkHttpClient): SpaceXApiRequest {
        val apiRequest = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(SpaceXApiRequest::class.java)

        return SpaceXApiRequestDecorator(apiRequest)
    }

    @Singleton
    @Provides
    @SpaceXApiQualifier
    fun httpClient(@SpaceXApiQualifier interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    @SpaceXApiQualifier
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}
