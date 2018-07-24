package com.thoughtbeats.pranay.kotlinmvvm.ui.mainActivity

import android.app.Activity
import android.content.Context
import com.thoughtbeats.pranay.kotlinmvvm.base.fragment.AbstractBaseFragment
import com.thoughtbeats.pranay.kotlinmvvm.base.viewmodel.AbstractViewModel

abstract class AbstractBaseMainFragment<VM:AbstractViewModel>:AbstractBaseFragment<VM>()
{
        private lateinit var uiInteraction :AbstractBaseMainActivity.UiInteracion

        fun getUiInteraction():AbstractBaseMainActivity.UiInteracion=uiInteraction

      override  fun onAttach(context: Context) {
                super.onAttach(context)
                attach(context)
        }
       override fun onAttach(activity: Activity) {
                super.onAttach(activity)
                attach(activity)
        }

        private fun attach(activityOrContext: Context) {
                uiInteraction = activityOrContext as AbstractBaseMainActivity.UiInteracion
                if (uiInteraction == null) {
                        throw NullPointerException("Please extends " + AbstractBaseMainActivity::class.java!!.getName() + " interface to your calling activity")
                }
        }
}