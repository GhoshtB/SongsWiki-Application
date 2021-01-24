package com.example.myapplicationexample.api

import com.example.myapplicationexample.model.track.toptrack.TopTracks
import com.example.myapplicationexample.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewMusicService {

    @GET("?method=artist.getTopTracks&api_key=${Constants.api_key}&format=json")
    fun getArtistTopTracks(@Query("artist") artist:String): Call<TopTracks>

}