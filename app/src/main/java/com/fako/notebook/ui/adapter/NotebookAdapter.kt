package com.fako.notebook.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fako.notebook.MainFragmentDirections
import com.fako.notebook.data.entity.Notes
import com.fako.notebook.databinding.CardViewBinding
import com.fako.notebook.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class NotebookAdapter(var mcontext: Context,var noteList: List<Notes>, var viewModel:MainViewModel):
    RecyclerView.Adapter<NotebookAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardViewBinding) :RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val binding = CardViewBinding.inflate(LayoutInflater.from(mcontext),parent,false)
        return CardTasarimTutucu(binding)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val note = noteList.get(position)
        val t = holder.tasarim
        t.textViewTittle.text =note.title
        t.textViewNote.text = note.description

        t.cardViewSatR.setOnClickListener{
            val gecis = MainFragmentDirections.actionMainFragmentToDetailFragment(NOTE = note)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${note.id} silinsin mi ?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(note.id)
                }.show()
        }

    }
    override fun getItemCount(): Int {
        return noteList.size
    }
}