package com.example.imagesearchapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.imagesearchapp.data.UnsplashRepository

//"ViewModelInject" is just the same as "Inject" Keyword
class GalleryViewModel @ViewModelInject constructor(private val repository: UnsplashRepository) :
    ViewModel() {
}