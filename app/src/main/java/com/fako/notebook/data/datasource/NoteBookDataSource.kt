package com.fako.notebook.data.datasource

import android.util.Log
import com.fako.notebook.data.entity.Notes
import com.fako.notebook.room.NotebookDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteBookDataSource(var ndao:NotebookDao) {
    suspend fun bringNotes():List<Notes> = withContext(Dispatchers.IO){


        return@withContext ndao.bringNotes()
    }
   suspend fun ara(aramakelimesi:String):List<Notes> = withContext(Dispatchers.IO){

       return@withContext ndao.ara(aramakelimesi)
    }
   suspend fun kaydet(title:String,descrip:String){
       val yeniNotes = Notes(0,title,descrip)
        ndao.kaydet(yeniNotes)
    }
   suspend fun guncelle(id:Int,title:String,description:String){
        val guncel = Notes(id,title,description)
       ndao.update(guncel)
    }
   suspend fun sil(id:Int){
        val delet = Notes(id,"","")
       ndao.delete(delet)
    }
}