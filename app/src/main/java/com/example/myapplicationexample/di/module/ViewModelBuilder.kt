package com.example.myapplicationexample.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationexample.ui.viewmodel.ViewmodelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [AppViewModelBuilder::class])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewmodelFactory): ViewModelProvider.Factory
}