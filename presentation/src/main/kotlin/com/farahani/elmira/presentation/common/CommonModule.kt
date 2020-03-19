package com.farahani.elmira.presentation.common

import com.farahani.elmira.presentation.common.executor.ExecutionModule
import dagger.Module

/**
 * Created by elmira on 11, March, 2020
 */
@Module(includes = [ExecutionModule::class])
abstract class CommonModule