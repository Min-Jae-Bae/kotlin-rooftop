package com.example.kbsc_cooperate.data.pagig

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kbsc_cooperate.data.remote.UnsplashApi
import com.example.kbsc_cooperate.model.UnsplashImage
import com.example.kbsc_cooperate.util.Constants.ITEMS_PER_PAGE

class SearchPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String,
) : PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response = unsplashApi.searchImages(query = query, perPage = ITEMS_PER_PAGE)
            val endOfPageReachedIsEmpty = response.images.isEmpty()

            if (endOfPageReachedIsEmpty) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPageReachedIsEmpty) null else currentPage + 1
                )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }
}
