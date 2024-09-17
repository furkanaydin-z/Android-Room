package com.fako.notebook.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "notebook")
data class Notes(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "id") @NotNull var id:Int,
                 @ColumnInfo(name = "title") @NotNull var title:String,
                 @ColumnInfo(name = "description") @NotNull var description:String
):Serializable
