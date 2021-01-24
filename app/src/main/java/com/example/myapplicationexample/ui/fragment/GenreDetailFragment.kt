package com.example.myapplicationexample.ui.fragment

import android.annotation.SuppressLint
import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.FragmentGenreDetailBinding
import com.example.myapplicationexample.model.Tag
import com.example.myapplicationexample.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [GenreDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenreDetailFragment : Fragment() {

    lateinit var binding: FragmentGenreDetailBinding

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_genre_detail, container, false)
        var tag: Tag = (activity as MainActivity).tag!!
        binding.tvDesc.text="Not Available"
        binding.ivBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        binding.viewPager.adapter = ViewPagerAdapter(activity!!.supportFragmentManager, 3)
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.tvTitle.text = tag.name
        return binding.root
    }

}