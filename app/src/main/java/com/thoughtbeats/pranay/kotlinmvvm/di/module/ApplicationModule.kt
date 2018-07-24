package com.thoughtbeats.pranay.kotlinmvvm.di.module

import com.thoughtbeats.pranay.kotlinmvvm.di.common.ApplicationScope
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class  ApplicationModule{
    enum class ApplicationMode{
        NORMAL,TESTING
    }

    @ApplicationScope
    @Provides
    fun provideApplicationMode()=ApplicationMode.NORMAL
}