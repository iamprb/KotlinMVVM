package com.thoughtbeats.pranay.kotlinmvvm.di.component

import android.app.Application
import android.support.annotation.UiThread
import com.thoughtbeats.pranay.kotlinmvvm.App
import com.thoughtbeats.pranay.kotlinmvvm.di.common.ApplicationScope
import com.thoughtbeats.pranay.kotlinmvvm.di.module.ApplicationModule
import com.thoughtbeats.pranay.kotlinmvvm.di.module.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@ApplicationScope
@Component(modules=[AndroidInjectionModule::class,
                    ApplicationModule::class,
                    ActivityModule::class])
interface ApplicationComponent{
    fun inject(application:App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():ApplicationComponent
    }

}