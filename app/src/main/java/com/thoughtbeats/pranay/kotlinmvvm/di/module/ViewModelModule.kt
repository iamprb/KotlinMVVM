package com.thoughtbeats.pranay.kotlinmvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel.BaseViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule{
    @Binds
    abstract fun bindViewModelFactory(factory:BaseViewModelFactory):ViewModelProvider.Factory
}