package com.example.myapplicationexample.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentTracksBinding
import com.example.myapplicationexample.model.Details
import com.example.myapplicationexample.ui.adapter.AlbumsAdapter
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel


/**
 * A simple [Fragment] subclass.
 * Use the [TracksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TracksFragment : Fragment() {

    lateinit var genresViewmodel: GenresViewmodel
    lateinit var binding:FragmentTracksBinding

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_tracks, container, false)

        genresViewmodel=(activity as MainActivity).genresViewmodel

        genresViewmodel.getTagTopTracks((activity as MainActivity).tag!!.name).observe(viewLifecycleOwner,{
            binding.rvTracks.apply {
                layoutManager= GridLayoutManager(activity!!.applicationContext,2)
                setHasFixedSize(true)
                if (it.tracks!=null && it.tracks.track.size>0)
                    adapter= AlbumsAdapter(it.tracks.track?.map { track-> Details(name = track.artist.name?:"",image = track.image?.get(3).text,track = track.name) },{})
            }
        })


       return binding.root
    }

}