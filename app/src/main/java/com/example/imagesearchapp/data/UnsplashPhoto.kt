package com.example.imagesearchapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto( //constructor with pars
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
) : Parcelable { //class body

    @Parcelize
    data class UnsplashPhotoUrls( //constructor with pars
            val raw: String,
            val full: String,
            val regular: String,
            val small: String,
            val thumb: String,
    ) : Parcelable

    @Parcelize
    data class UnsplashUser( //constructor with pars
            val name: String,
            val username: String
    ) : Parcelable { //class body
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }
}