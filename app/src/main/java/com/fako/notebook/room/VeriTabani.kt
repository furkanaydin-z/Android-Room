package com.fako.notebook.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fako.notebook.data.entity.Notes

@Database(entities = [Notes::class], version = 1)
abstract class VeriTabani: RoomDatabase() {

    abstract fun getNotesDao():NotebookDao



}
