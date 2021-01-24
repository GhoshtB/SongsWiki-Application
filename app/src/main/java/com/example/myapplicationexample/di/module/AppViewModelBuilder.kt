package com.example.myapplicationexample.di.module

import androidx.lifecycle.ViewModel
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @viewmodelkey(GenresViewmodel::class)
    abstract fun bindHomeViewModel(homeViewModel: GenresViewmodel): ViewModel

}