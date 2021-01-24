package com.example.myapplicationexample.app

import com.example.myapplicationexample.di.DaggerMusicComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MusicWikiApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMusicComponent.builder().application(this).build()
    }
}