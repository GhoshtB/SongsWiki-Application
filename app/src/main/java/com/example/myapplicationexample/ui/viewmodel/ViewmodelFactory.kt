package com.example.myapplicationexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ViewmodelFactory @Inject constructor(val values:Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = values[modelClass]?:values.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value?: throw IllegalArgumentException("")

        return creator.get() as T
    }
}