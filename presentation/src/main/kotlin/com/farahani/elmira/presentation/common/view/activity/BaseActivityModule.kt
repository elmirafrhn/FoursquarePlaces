package com.farahani.elmira.presentation.common.view.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.farahani.elmira.presentation.common.di.PerActivity
import com.farahani.elmira.presentation.common.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by elmira on 17, March, 2020
 */
@Module
abstract class BaseActivityModule {

    @Module
    companion object {
        const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"

        @JvmStatic
        @Provides
        @Named(ACTIVITY_FRAGMENT_MANAGER)
        @PerActivity
        fun provideActivityFragmentManager(activity: AppCompatActivity): FragmentManager {
            return activity.supportFragmentManager
        }
    }

    @Binds
    @PerActivity
    abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory


}
