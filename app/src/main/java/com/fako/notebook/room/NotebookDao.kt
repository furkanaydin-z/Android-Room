package com.fako.notebook.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fako.notebook.data.entity.Notes

@Dao
interface NotebookDao {
    @Query("SELECT * FROM  notebook")
    suspend fun bringNotes():List<Notes>

    @Insert
   suspend fun kaydet(note:Notes)

    @Update
   suspend fun update(note: Notes)

    @Delete
   suspend fun delete(note: Notes)

    @Query("SELECT * FROM  notebook WHERE title like '%' || :aramaKelimesi ||  '%'")
    suspend fun ara(aramaKelimesi:String):List<Notes>
}