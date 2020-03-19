package com.farahani.elmira.domain.transformer

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import javax.inject.Inject

/**
 * Created by elmira on 11, March, 2020
 */
class FTransformerImpl<T> @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : FTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}