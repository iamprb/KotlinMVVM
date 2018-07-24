package com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.activity

import android.os.Bundle
import com.thoughtbeats.pranay.kotlinmvvm.R
import com.thoughtbeats.pranay.kotlinmvvm.base.activity.AbstractBaseNormalActivity
import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.AbstractBaseMainActivity
import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.MainActivityNavigationController
import javax.inject.Inject

class MainActivity : AbstractBaseNormalActivity(),AbstractBaseMainActivity.UiInteracion {
    @Inject
    lateinit var navController:MainActivityNavigationController

    override fun getNavigationController()=navController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController.navigateToFirstFragment()
    }
}
