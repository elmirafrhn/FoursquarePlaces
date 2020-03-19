package com.farahani.elmira.domain.usecase

import io.reactivex.Completable

/**
 * Created by elmira on 11, March, 2020
 */
abstract class UseCaseCompletable<P> {

    operator fun invoke(param: P?): Completable {
        return if (param != null) {
            execute(param)
        } else {
            Completable.error(IllegalArgumentException())
        }
    }

    protected abstract fun execute(param: P): Completable
}

operator fun UseCaseCompletable<Unit>.invoke(): Completable = this(Unit)