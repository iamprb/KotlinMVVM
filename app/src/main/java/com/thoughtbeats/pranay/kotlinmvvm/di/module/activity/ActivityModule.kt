package com.thoughtbeats.pranay.kotlinmvvm.di.module.activity

import com.thoughtbeats.pranay.kotlinmvvm.di.module.fragment.FirstFragmentModule
import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun contributeMainActivity():MainActivity
}