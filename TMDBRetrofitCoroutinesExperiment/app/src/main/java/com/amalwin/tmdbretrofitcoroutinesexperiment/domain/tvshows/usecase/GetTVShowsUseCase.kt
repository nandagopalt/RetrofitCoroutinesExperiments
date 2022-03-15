package com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.usecase

import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShowList
import com.amalwin.tmdbretrofitcoroutinesexperiment.domain.tvshows.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}