package com.farahani.elmira.data.common.executor

import com.farahani.elmira.domain.transformer.ThreadExecutor
import dagger.Binds
import dagger.Module

/**
 * Created by elmira on 16, March, 2020
 */
@Module
abstract class ExecutionModule {

    @Binds
    abstract fun threadExecutor(jobExecutor: JobExecutor): ThreadExecutor

}