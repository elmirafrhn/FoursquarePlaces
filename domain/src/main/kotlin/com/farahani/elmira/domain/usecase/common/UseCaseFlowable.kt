package com.farahani.elmira.domain.usecase

import io.reactivex.Flowable

/**
 * Created by elmira on 11, March, 2020
 */
abstract class UseCaseFlowable<R, P> {

    operator fun invoke(param: P?): Flowable<R> {
        return if (param != null) {
            execute(param)
        } else {
            Flowable.error(IllegalArgumentException())
        }
    }

    protected abstract fun execute(param: P): Flowable<R>

}

operator fun <R> UseCaseFlowable<R, Unit>.invoke(): Flowable<R> = this(Unit)