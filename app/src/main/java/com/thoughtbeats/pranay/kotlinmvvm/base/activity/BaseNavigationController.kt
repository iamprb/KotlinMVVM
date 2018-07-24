package com.thoughtbeats.pranay.kotlinmvvm.base.activity

import android.support.v4.app.FragmentManager

abstract class BaseNavigationController(private val fragmentManager: FragmentManager){

    fun getFragmentManager()=fragmentManager

}