package com.example.myapplicationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.myapplicationexample.databinding.FragmentGenresBinding
import com.example.myapplicationexample.model.Details
import com.example.myapplicationexample.model.Tag
import com.example.myapplicationexample.ui.viewmodel.GenresViewmodel
import com.example.myapplicationexample.ui.viewmodel.ViewmodelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    var tag: Tag? = null

    lateinit var genresViewmodel: GenresViewmodel
    var details:Details? = null

    @Inject
    lateinit var viewmodelFactory: ViewmodelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        genresViewmodel = viewmodelFactory.create(GenresViewmodel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentGenres).navigateUp()
    }

}