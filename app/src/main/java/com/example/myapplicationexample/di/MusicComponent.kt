package com.example.myapplicationexample.di

import android.app.Application
import com.example.myapplicationexample.app.MusicWikiApp
import com.example.myapplicationexample.di.module.ActivityBuilder
import com.example.myapplicationexample.di.module.AppModule
import com.example.myapplicationexample.di.module.MainActivityProviders
import com.example.myapplicationexample.di.module.ViewModelBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,AppModule::class,ViewModelBuilder::class, ActivityBuilder::class])
interface MusicComponent : AndroidInjector<MusicWikiApp>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application):Builder

        fun build():MusicComponent

    }
}