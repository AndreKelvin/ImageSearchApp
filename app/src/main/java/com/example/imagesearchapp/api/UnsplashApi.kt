package com.example.imagesearchapp.api

import com.example.imagesearchapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID")
    @GET("search/photos")
    suspend fun searchPhotos(
//the keyword "suspend" means this fun is gonna perform long task (Coroutine)
        //the value name must be the same with the ones in database(GSon)
        @Query("query") query: String,
        @Query("page") page: String,
        @Query("per_page") perpage: String,
    ): UnsplashResponse

}