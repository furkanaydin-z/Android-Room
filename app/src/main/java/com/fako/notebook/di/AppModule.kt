package com.fako.notebook.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fako.notebook.data.datasource.NoteBookDataSource
import com.fako.notebook.data.repo.NoteBookRepository
import com.fako.notebook.room.NotebookDao
import com.fako.notebook.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNotebookDataSource(ndao:NotebookDao):NoteBookDataSource {
        return NoteBookDataSource(ndao)
    }

    @Provides
    @Singleton
    fun provideNotebookRepository(nds:NoteBookDataSource):NoteBookRepository{
        return NoteBookRepository(nds)
    }
    @Provides
    @Singleton
    fun provideNotebookDao(@ApplicationContext context: Context):NotebookDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"note.sqlite")
            .createFromAsset("note.sqlite").build()
        return vt.getNotesDao()
    }

}