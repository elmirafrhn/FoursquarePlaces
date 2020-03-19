package com.farahani.elmira.domain.transformer

import io.reactivex.Scheduler

/**
 * Created by elmira on 11, March, 2020
 */
interface PostExecutionThread {

    fun scheduler(): Scheduler
}