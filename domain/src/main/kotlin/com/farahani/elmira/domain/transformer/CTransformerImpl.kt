package com.farahani.elmira.domain.transformer

import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by elmira on 11, March, 2020
 */
class CTransformerImpl @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : CTransformer() {

    override fun apply(upstream: Completable): CompletableSource =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}