package com.farahani.elmira.presentation.common.view.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.farahani.elmira.presentation.common.di.PerFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by elmira on 17, March, 2020
 */
@Module
abstract class BaseFragmentModule {

    @Module
    companion object {

        const val FRAGMENT = "BaseFragmentModule.fragment"

        const val CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager"

        /*
         * This is a valid way to declare static provides methods.
         * See https://github.com/google/dagger/issues/900#issuecomment-337043187
         */
        @JvmStatic
        @Provides
        @Named(CHILD_FRAGMENT_MANAGER)
        @PerFragment
        fun childFragmentManager(@Named(FRAGMENT) fragment: Fragment): FragmentManager =
            fragment.childFragmentManager

    }
}