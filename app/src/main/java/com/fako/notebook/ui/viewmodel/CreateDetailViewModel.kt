package com.fako.notebook.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.fako.notebook.data.repo.NoteBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateDetailViewModel @Inject constructor(var nrepo:NoteBookRepository):ViewModel() {
     fun kaydet(title:String,descrip:String){
         CoroutineScope(Dispatchers.Main).launch {
             nrepo.kaydet(title,descrip)
         }
     }
}