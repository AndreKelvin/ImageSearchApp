package com.example.imagesearchapp.data

import androidx.paging.PagingSource
import com.example.imagesearchapp.api.UnsplashApi
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

//This class takes data from Rest Api(Retrofit) and turn it into pages
class UnsplashPagingSource(private val unsplashApi: UnsplashApi, private val query: String) :
    PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX// if params is null load page 1

        return try {
            val response = unsplashApi.searchPhotos(query,position,params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}