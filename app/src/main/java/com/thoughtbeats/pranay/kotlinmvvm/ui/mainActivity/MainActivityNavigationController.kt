package com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity

import com.thoughtbeats.pranay.kotlinmvvm.R
import com.thoughtbeats.pranay.kotlinmvvm.base.activity.AbstractNavigatonController
import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.activity.MainActivity
import com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity.fragment.FirstFragment
import javax.inject.Inject

class MainActivityNavigationController @Inject constructor(mainActivity: MainActivity)
                    :AbstractNavigatonController(mainActivity)
{
    override fun provideContainerId()= R.id.container

    fun navigateToFirstFragment(){
        changeFragment(FirstFragment(),true)
        updateFragment()
    }

}