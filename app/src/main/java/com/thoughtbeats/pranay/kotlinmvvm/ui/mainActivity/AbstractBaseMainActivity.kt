package com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity

import com.thoughtbeats.pranay.kotlinmvvm.base.activity.AbstractBaseNormalActivity

abstract class AbstractBaseMainActivity:AbstractBaseNormalActivity(){

    interface UiInteracion{
        fun getNavigationController() :MainActivityNavigationController
    }

}