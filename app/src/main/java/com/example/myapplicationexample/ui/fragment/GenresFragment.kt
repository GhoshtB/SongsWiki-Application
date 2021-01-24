package com.example.myapplicationexample.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentGenresBinding
import com.example.myapplicationexample.model.Tag
import com.example.myapplicationexample.ui.adapter.GeneresAdapter
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel
import com.example.myapplicationexample.ui.viewmodel.ViewmodelFactory
import dagger.android.support.DaggerFragment
import java.util.ArrayList
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [GenresFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenresFragment : DaggerFragment() {

    private lateinit var tags: List<Tag>

    lateinit var binding: FragmentGenresBinding
    lateinit var genresViewmodel:GenresViewmodel

    val generesAdapter = GeneresAdapter({
        (activity as MainActivity).tag=this
        requireView().findNavController().navigate(R.id.fragmentGenresDetail)
    })
    var flag=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_genres, container, false)

       genresViewmodel=(activity as MainActivity).genresViewmodel



        binding.rvGeneres.apply {
            setHasFixedSize(true)
            layoutManager=GridLayoutManager(requireActivity().applicationContext,3)
            adapter= generesAdapter
        }

        genresViewmodel.getMusucGenres().observe(viewLifecycleOwner, {
            Log.d("TAG genresViewmodel", "onCreateView: ${it.tags.tag.size}")
            tags=it.tags.tag
           generesAdapter.apply {
               tag=it.tags.tag.subList(0,12)
               notifyDataSetChanged()
           }
        })

        binding.ivHide.setOnClickListener {
            if (flag==0){
                binding.ivHide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down)
                generesAdapter.apply {
                    tag=tags
                    notifyDataSetChanged()
                }
                flag=1
            }else{
                generesAdapter.apply {
                    tag= tags.subList(0,12)
                    notifyDataSetChanged()
                }
                binding.ivHide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up)
                flag=0
            }
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}