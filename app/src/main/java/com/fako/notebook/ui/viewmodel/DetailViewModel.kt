package com.fako.notebook.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.fako.notebook.data.repo.NoteBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var nrepo:NoteBookRepository):ViewModel() {

     fun guncelle(id:Int,title:String,description:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.guncelle(id,title,description)
        }
    }
}