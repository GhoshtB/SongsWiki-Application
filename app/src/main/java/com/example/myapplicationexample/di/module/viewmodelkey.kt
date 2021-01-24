package com.example.myapplicationexample.di.module

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION,
AnnotationTarget.PROPERTY_SETTER,AnnotationTarget.PROPERTY_GETTER)
@MustBeDocumented
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class viewmodelkey(val viewmodel : KClass<out ViewModel>)
