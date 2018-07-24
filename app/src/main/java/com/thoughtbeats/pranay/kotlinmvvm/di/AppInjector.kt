package com.thoughtbeats.pranay.kotlinmvvm.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.thoughtbeats.pranay.kotlinmvvm.App
import com.thoughtbeats.pranay.kotlinmvvm.base.fragment.InjectableFragment
import com.thoughtbeats.pranay.kotlinmvvm.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

class AppInjector {

    fun initialze(application: App){
        //DaggerApplicationComponent here

        DaggerApplicationComponent
                .builder()
                .application(application)
                .build()
                .inject(application)




    application.registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{
        override fun onActivityPaused(p0: Activity?) {
            //Empty method
        }

        override fun onActivityResumed(p0: Activity?) {
            //Empty method
        }

        override fun onActivityStarted(p0: Activity?) {
            //Empty method
        }

        override fun onActivityDestroyed(p0: Activity?) {
            //Empty method
        }

        override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
            //Empty method
        }

        override fun onActivityStopped(p0: Activity?) {
            //Empty method
        }

        override fun onActivityCreated(activity: Activity?, p1: Bundle?) {
            injectActivity(activity)
        }

    })
    }
    fun injectActivity(activity: Activity?){
        if(activity is HasSupportFragmentInjector){
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                                    if (f is InjectableFragment) {
                                        AndroidSupportInjection.inject(f)
                                    }
                                }
                            }, true)
        }
    }

}
