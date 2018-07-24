package com.thoughtbeats.pranay.kotlinmvvm

import android.app.Activity
import android.app.Service
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.thoughtbeats.pranay.kotlinmvvm.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class App : MultiDexApplication(),HasServiceInjector,HasActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var dispatchingAndroidServiceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        //App injector initialization here
        AppInjector().initialze(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun serviceInjector()=dispatchingAndroidServiceInjector

    override fun activityInjector()=dispatchingAndroidInjector


}