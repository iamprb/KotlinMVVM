package com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel

import android.arch.lifecycle.ViewModel
import android.view.View

abstract class AbstractViewModel :ViewModel(){
        abstract fun getViewModel():ViewModel
}