package com.thoughtbeats.pranay.kotlinmvvm.base.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class AbstractBaseNormalActivity : AppCompatActivity(),HasSupportFragmentInjector{
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector()=dispatchingAndroidInjector

}