package com.thoughtbeats.pranay.kotlinmvvm.base.activity

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
abstract class AbstractNavigatonController(private val activity: AppCompatActivity)
    : BaseNavigationController(activity.supportFragmentManager) {

    private var fragmentToChange: Fragment? = null
    private var isBackStack: Boolean = false

    protected fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        this.fragmentToChange = fragment
        this.isBackStack = addToBackStack
    }

    protected fun updateFragment() {
        if (this.fragmentToChange == null) {
            return
        }
        val backStackName = this.fragmentToChange?.javaClass?.simpleName

        val isPop = getFragmentManager().popBackStackImmediate(backStackName, 0)
        if (!isPop /*&& getFragmentManager().findFragmentByTag(backStackName) == null*/) {
            val fragmentTransaction = getFragmentManager().beginTransaction()
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.replace(provideContainerId(), this.fragmentToChange!!, backStackName)
            if (this.isBackStack) {
                fragmentTransaction.addToBackStack(backStackName)
            }
            fragmentTransaction.commit()
        }
        this.fragmentToChange = null
        this.isBackStack = false
    }

    protected fun updateFragment(fragment: Fragment, backStackName: String) {
        val fragmentTransaction = getFragmentManager().beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.replace(provideContainerId(), fragment, backStackName)
        fragmentTransaction.addToBackStack(backStackName)
        fragmentTransaction.commit()
    }

    fun popBackStackInclusive(backStackName: String) {
        getFragmentManager().popBackStackImmediate(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun popBackStackImmediate(backStackName: String) {
        getFragmentManager().popBackStackImmediate(backStackName, 0)
    }

    fun popBackStackImmediate() {
        getFragmentManager().popBackStackImmediate()
    }

    @IdRes
    protected abstract fun provideContainerId(): Int

    fun getActivity()=activity


}