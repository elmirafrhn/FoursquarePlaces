package com.farahani.elmira.domain.transformer

import io.reactivex.FlowableTransformer

abstract class FTransformer<T> : FlowableTransformer<T, T>