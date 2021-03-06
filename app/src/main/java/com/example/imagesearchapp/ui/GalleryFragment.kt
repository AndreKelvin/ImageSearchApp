package com.example.imagesearchapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.imagesearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //Marks an Android class to be setup for injection
class GalleryFragment : Fragment(R.layout.fragment_gallery){

    private val viewModel by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.photos.observe(viewLifecycleOwner) {

        }
    }

}