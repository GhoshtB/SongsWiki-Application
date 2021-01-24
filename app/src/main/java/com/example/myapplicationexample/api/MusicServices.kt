package com.example.myapplicationexample.api

import com.example.myapplicationexample.model.MusicDetails
import com.example.myapplicationexample.model.alb.Albums
import com.example.myapplicationexample.model.alb.topalbm.TopAlbums
import com.example.myapplicationexample.model.artist.TopArtists
import com.example.myapplicationexample.model.track.TopTracks
import com.example.myapplicationexample.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicServices {
//    http://ws.audioscrobbler.com/2.0/?method=chart.getTopTags&api_key=c262f5f4b6cd5dc01a3b82da277dbc0d&format=json
    @GET("?method=chart.getTopTags&api_key=${Constants.api_key}&format=json")
    fun getTags():Call<MusicDetails>

    @GET("?method=tag.gettopalbums&api_key=${Constants.api_key}&format=json")
    fun getTagTopAlbums(@Query("tag",encoded = false) genre:String):Call<Albums>


    @GET("?method=tag.getTopArtists&api_key=${Constants.api_key}&format=json")
    fun getTagTopartists(@Query("tag") genre:String):Call<TopArtists>


    @GET("?method=tag.getTopTracks&api_key=${Constants.api_key}&format=json")
    fun getTagTopTracks(@Query("tag") genre:String):Call<TopTracks>
//    https://ws.audioscrobbler.com/2.0/?method=artist.getTopTracks&artist=Coldplay&api_key=c262f5f4b6cd5dc01a3b82da277dbc0d&format=json&tag=rock

    @GET("?method=artist.getTopTracks&api_key=${Constants.api_key}&format=json")
    fun getArtistTopTracks(@Query("artist") artist:String):Call<TopTracks>


    @GET("?method=artist.getTopAlbums&api_key=${Constants.api_key}&format=json")
    fun getArtistTopAlbums(@Query("artist") artist:String):Call<TopAlbums>


}