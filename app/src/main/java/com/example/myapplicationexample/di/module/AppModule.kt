package com.example.myapplicationexample.di.module

import com.example.myapplicationexample.api.CommonApiServices
import com.example.myapplicationexample.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class AppModule {

    @Singleton
    @Provides
    fun providesApiservice():CommonApiServices{
        return CommonApiServices()
    }

    @Singleton
    @Provides
    fun providesRepository(commonApiServices: CommonApiServices): Repository {
        return Repository(commonApiServices)
    }

}