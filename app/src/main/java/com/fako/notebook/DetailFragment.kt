package com.fako.notebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fako.notebook.databinding.FragmentDetailBinding
import com.fako.notebook.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding:FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        binding.detailFragment = this

        binding.detaildToolbar = "Uptade"

        val bundle:DetailFragmentArgs by navArgs()
        val noteRoad = bundle.NOTE
        binding.dataClass = noteRoad

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun guncelle(id:Int,title:String,description:String){
        viewModel.guncelle(id,title,description)
    }
}