package com.fako.notebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.fako.notebook.databinding.FragmentCreateDetailBinding
import com.fako.notebook.ui.viewmodel.CreateDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateDetailFragment : Fragment() {
    private lateinit var viewModel: CreateDetailViewModel
    private lateinit var binding: FragmentCreateDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_detail,container,false)
        binding.createDetailFragment = this

        binding.createdToolbar = "Save"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : CreateDetailViewModel by viewModels()
        viewModel =tempViewModel
    }

    fun kaydet(title:String,descrip:String){
        viewModel.kaydet(title,descrip)
    }
}