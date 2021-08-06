package com.example.imagesearchapp.data

import com.example.imagesearchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//Injecting UnsplashApi to this Repository class constructor
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}