package com.farahani.elmira.presentation.common.executor

import com.farahani.elmira.domain.transformer.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by elmira on 11, March, 2020
 */
class UiThread @Inject constructor() : PostExecutionThread {

    override fun scheduler(): Scheduler = AndroidSchedulers.mainThread()

}