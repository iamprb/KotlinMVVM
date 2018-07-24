package com.thoughtbeats.pranay.kotlinmvvm.base.activity

import android.support.v4.app.Fragment

abstract class AbstractFragmentNavigationController(val fragment:Fragment)
                        :BaseNavigationController(fragment.childFragmentManager)
