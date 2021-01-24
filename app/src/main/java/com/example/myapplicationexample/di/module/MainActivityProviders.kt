package com.example.myapplicationexample.di.module

import com.example.myapplicationexample.ui.fragment.GenresFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun providesGenreFragment():GenresFragment
}