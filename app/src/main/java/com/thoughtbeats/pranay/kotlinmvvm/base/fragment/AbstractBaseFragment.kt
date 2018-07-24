package com.thoughtbeats.pranay.kotlinmvvm.base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel.AbstractViewModel
import com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel.BaseViewModelFactory
import javax.inject.Inject

abstract class AbstractBaseFragment<VM:AbstractViewModel>
            :Fragment(),InjectableFragment,FragmentUiTransaction
{
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel:VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

    }

    override fun onFragmentBackPress()=false
    protected abstract fun getViewModel(): Class<VM>

    @LayoutRes
    protected abstract fun getLayout(): Int
}