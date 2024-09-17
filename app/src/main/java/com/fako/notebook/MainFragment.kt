package com.fako.notebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.fako.notebook.data.entity.Notes
import com.fako.notebook.databinding.FragmentMainBinding
import com.fako.notebook.ui.adapter.NotebookAdapter
import com.fako.notebook.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log
@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var viewModel:MainViewModel
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.mainFragment = this
        binding.maindToolbar = "MainPage"

        viewModel.noteList.observe(viewLifecycleOwner){
            val noteAdapter = NotebookAdapter(requireContext(),it,viewModel)
            binding.nAdapter = noteAdapter
        }



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
            return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val  tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_createDetailFragment)

    }

    override fun onResume() {
        super.onResume()
        viewModel.bringNotes()
    }

}