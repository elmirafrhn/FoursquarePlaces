package com.farahani.elmira.domain.usecase

import com.farahani.elmira.domain.entity.SearchVenuesRequest
import com.farahani.elmira.domain.repository.VenuesRepository
import com.farahani.elmira.domain.transformer.CTransformer
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by elmira on 11, March, 2020
 */
class SearchVenuesUseCase @Inject constructor(
    private val repository: VenuesRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<SearchVenuesRequest>() {
    override fun execute(param: SearchVenuesRequest): Completable =
        repository.searchVenues(param).compose(transformer)
}