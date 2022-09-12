package com.kadirsener.happyfood.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "foods")
data class Food(
    @SerializedName("name")
    val name : String,
    @SerializedName("calories")
    val calorie : Int,
    @SerializedName("fat_total_g")
    val fat : Int,
    @SerializedName("protein_g")
    val protein : Int,
    @PrimaryKey(autoGenerate = true)
    val foodId : Int? = null
)
