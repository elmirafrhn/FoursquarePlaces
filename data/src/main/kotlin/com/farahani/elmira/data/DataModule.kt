package com.farahani.elmira.data

import com.farahani.elmira.data.entity.EntityModule
import dagger.Module

/**
 * Created by elmira on 16, March, 2020
 */
@Module(includes = [EntityModule::class])
abstract class DataModule {
}