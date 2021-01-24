package com.example.myapplicationexample.api

import com.example.myapplicationexample.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommonApiServices {

    lateinit var retrofit: Retrofit
    val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()

    var interceptor: Interceptor = Interceptor { chain ->
        val newChains = chain.request().newBuilder()

        newChains.addHeader("user-agent", "Dataquest")

        chain.proceed(newChains.build())
    }

    val loggingsInterceptor :HttpLoggingInterceptor
    get() {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS }.level = HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor
    }


    init {

        okHttpClient.addInterceptor(interceptor)
        okHttpClient.addInterceptor(loggingsInterceptor)
    }

    fun <T> getApiServices(url: String, classes: Class<T>): T {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit.create(classes)

    }
}