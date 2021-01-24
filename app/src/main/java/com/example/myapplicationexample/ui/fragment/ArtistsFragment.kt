package com.example.myapplicationexample.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentArtistsBinding
import com.example.myapplicationexample.model.Details
import com.example.myapplicationexample.ui.adapter.AlbumsAdapter
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel


/**
 * A simple [Fragment] subclass.
 * Use the [ArtistsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistsFragment : Fragment() {

    lateinit var genresViewmodel: GenresViewmodel
    lateinit var binding:FragmentArtistsBinding

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_artists, container, false)

        genresViewmodel=(activity as MainActivity).genresViewmodel

        genresViewmodel.getTagTopartists((activity as MainActivity).tag!!.name).observe(viewLifecycleOwner,{
            binding.rvArtists.apply {
                layoutManager= GridLayoutManager(activity!!.applicationContext,2)
                setHasFixedSize(true)
                if (it.topartists!=null && it.topartists.artist.size>0)
                    adapter= AlbumsAdapter(it.topartists.artist?.map { artist-> Details(name = artist.name?:"",image = artist.image?.get(2).text) },{
                        (activity as MainActivity).details=this
                        view!!.findNavController().navigate(R.id.fragmentSongs)
                    })
            }
        })

       return binding.root
    }

}