package com.thoughtbeats.pranay.kotlinmvvm.base.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractBaseMvvmActivity<VM:AbstractViewModel>:AbstractBaseNormalActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

    }
    protected abstract fun getViewModel(): Class<VM>
}