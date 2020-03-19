package com.farahani.elmira.presentation.common.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.farahani.elmira.presentation.common.extension.addFragment
import com.farahani.elmira.presentation.common.extension.replaceFragment
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by elmira on 17, March, 2020
 */
abstract class BaseFragment :
    DaggerFragment() {

    @Inject
    protected lateinit var activityContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        // This is called even for API levels below 23 if we didn't use AppCompat.
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    protected fun addChildFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false
    ) = childFragmentManager.addFragment(containerViewId, fragment, addToBackStack)

    protected fun replaceChildFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false
    ) = childFragmentManager.replaceFragment(containerViewId, fragment, addToBackStack)

    protected fun currentChildFragment() =
        childFragmentManager.fragments.lastOrNull() as? BaseFragment
}
