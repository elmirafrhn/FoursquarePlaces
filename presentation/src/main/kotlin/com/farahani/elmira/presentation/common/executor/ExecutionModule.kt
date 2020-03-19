package com.farahani.elmira.presentation.common.executor

import com.farahani.elmira.domain.transformer.PostExecutionThread
import dagger.Binds
import dagger.Module

/**
 * Created by elmira on 11, March, 2020
 */
@Module
abstract class ExecutionModule {

    @Binds
    abstract fun postExecutionThread(uiThread: UiThread): PostExecutionThread

}