package com.kadirsener.happyfood.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "foods")
data class Food(
    val name : String,
    val calorie : Int,
    val fat : Int,
    val protein : Int,
    @PrimaryKey(autoGenerate = true)
    val foodId : Int? = null
)
