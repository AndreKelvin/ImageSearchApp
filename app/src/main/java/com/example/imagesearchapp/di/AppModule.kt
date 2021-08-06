package com.example.imagesearchapp.di

import com.example.imagesearchapp.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//All this are how to use Dagger Hilt
//This will inject Retrofit instance to the class its needed
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)
        //Since the paras needs a Retrofit value and no Retrofit instance in this fun
        //Dagger Hilt will automatically provide the instance
        //Because its already defined in "provideRetrofit" fun(This is what Dependency Injection do)

}