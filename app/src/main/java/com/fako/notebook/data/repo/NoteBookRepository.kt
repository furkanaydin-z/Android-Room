package com.fako.notebook.data.repo

import com.fako.notebook.data.datasource.NoteBookDataSource
import com.fako.notebook.data.entity.Notes

class NoteBookRepository(var nds:NoteBookDataSource) {
    suspend fun kaydet(title:String,descrip:String)=nds.kaydet(title,descrip)
    suspend fun guncelle(id:Int,title:String,description:String)= nds.guncelle(id,title,description)
    suspend fun sil(id:Int) = nds.sil(id)
    suspend fun bringNotes():List<Notes> = nds.bringNotes()
    suspend fun ara(aramakelimesi:String):List<Notes> = nds.ara(aramakelimesi)
}