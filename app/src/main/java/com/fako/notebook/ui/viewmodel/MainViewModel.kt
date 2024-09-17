package com.fako.notebook.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fako.notebook.data.entity.Notes
import com.fako.notebook.data.repo.NoteBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var nrepo:NoteBookRepository):ViewModel() {

    var noteList = MutableLiveData<List<Notes>>()

    init {
        bringNotes()
    }

     fun sil(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.sil(id)
            bringNotes()
        }
    }
     fun bringNotes(){
         CoroutineScope(Dispatchers.Main).launch {
            noteList.value = nrepo.bringNotes()
         }
     }
     fun ara(aramakelimesi:String){
         CoroutineScope(Dispatchers.Main).launch {
             noteList.value = nrepo.ara(aramakelimesi)
         }
     }
}