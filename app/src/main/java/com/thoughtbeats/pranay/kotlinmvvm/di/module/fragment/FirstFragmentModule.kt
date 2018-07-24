package com.thoughtbeats.pranay.kotlinmvvm.di.module.fragment

import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.fragment.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FirstFragmentModule{
    @ContributesAndroidInjector
    abstract fun contributeFirstFragment():FirstFragment
}