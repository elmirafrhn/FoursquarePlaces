package com.farahani.elmira.presentation.common.view.activity

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.farahani.elmira.presentation.common.extension.addFragment
import com.farahani.elmira.presentation.common.extension.detachFragment
import com.farahani.elmira.presentation.common.extension.replaceFragment
import com.farahani.elmira.presentation.common.navigator.Navigator
import com.farahani.elmira.presentation.common.view.fragment.BaseFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by elmira on 17, March, 2020
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    protected val navigator: Navigator = Navigator

    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    protected fun addFragment(
        @IdRes containerViewId: Int, fragment: Fragment,
        addToBackStack: Boolean = false
    ) {
        supportFragmentManager.addFragment(containerViewId, fragment, addToBackStack)
    }

    protected fun replaceFragment(
        @IdRes containerViewId: Int, fragment: Fragment,
        addToBackStack: Boolean = false
    ) {
        supportFragmentManager.replaceFragment(containerViewId, fragment, addToBackStack)
    }

    protected fun detachFragment(fragment: Fragment, popBackStack: Boolean = false) {
        supportFragmentManager.detachFragment(fragment, popBackStack)
    }

    protected fun Disposable.track() {
        disposable.add(this)
    }

    @JvmName("trackDisposable")
    fun track(disposable: Disposable) {
        disposable.track()
    }

    protected fun Disposable.unTrack() {
        disposable.remove(this)
    }

    protected fun currentFragment() =
        if (supportFragmentManager.fragments.isNullOrEmpty())
            null
        else
            supportFragmentManager.fragments[supportFragmentManager.fragments.size - 1] as? BaseFragment
}