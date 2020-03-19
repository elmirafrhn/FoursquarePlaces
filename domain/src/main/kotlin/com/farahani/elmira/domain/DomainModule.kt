package com.farahani.elmira.domain

import com.farahani.elmira.domain.entity.SearchVenuesRequest
import com.farahani.elmira.domain.transformer.CTransformer
import com.farahani.elmira.domain.transformer.CTransformerImpl
import com.farahani.elmira.domain.transformer.FTransformer
import com.farahani.elmira.domain.transformer.FTransformerImpl
import dagger.Binds
import dagger.Module

/**
 * Created by elmira on 11, March, 2020
 */
@Module
abstract class DomainModule {

    @Binds
    abstract fun completableTransformer(
        transformer: CTransformerImpl
    ): CTransformer

    @Binds
    abstract fun flowableTransformer(
        transformer: FTransformerImpl<SearchVenuesRequest>
    ): FTransformer<SearchVenuesRequest>
}