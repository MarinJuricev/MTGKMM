package com.example.mtgkmm.feature.search.domain.model

data class Pagination(
    val totalCards: Int,
    val hasMore: Boolean,
    val nextPage: String,
)
