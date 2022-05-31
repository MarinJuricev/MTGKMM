package com.example.mtgkmm.android.feature.card.model

import android.os.Parcelable
import com.example.mtgkmm.feature.search.domain.model.Pagination
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiPagination(
    val totalCards: Int,
    val hasMore: Boolean,
    val nextPage: String,
) : Parcelable

fun Pagination.toUi(): UiPagination =
    UiPagination(
        totalCards = totalCards,
        hasMore = hasMore,
        nextPage = nextPage,
    )