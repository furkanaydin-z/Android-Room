package com.fako.notebook

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.fako.notebook.databinding.ActivityMainBinding
import com.fako.notebook.room.NotebookDao
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var notebookDao: NotebookDao
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            val notesList = notebookDao.bringNotes()

            // Log ile veritabanından gelen listeyi kontrol et
            Log.d("NotebookDao", "Notes List Size: ${notesList.size}")
            for (note in notesList) {
                Log.d("NotebookDao", "Note: ${note}")
            }
        }
    }
}