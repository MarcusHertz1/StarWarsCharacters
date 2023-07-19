package com.example.starwarscharacters

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {
    private lateinit var sharedPref: SharedPreferences

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("application", Context.MODE_PRIVATE)
    }

    private const val FAVORITE = "FAVORITE"

    fun addOrRemoveFavorite(id: String): Boolean { // false = id удалён, true = добавлен новый id
        val editor = sharedPref.edit()
        val favoriteString = getFavorite()
        favoriteString?.let { favorite ->
            val currentFavoriteArray = favorite.split(",").toMutableList()
            for(i in 0..currentFavoriteArray.lastIndex){
                if(currentFavoriteArray[i] == id) {
                    currentFavoriteArray.removeAt(i)
                    editor.putString(FAVORITE, currentFavoriteArray.joinToString(separator = ","))
                    editor.apply()
                    return false
                }
            }
        }
        editor.putString(FAVORITE, favoriteString + if(favoriteString=="") id else ",$id")
        editor.apply()
        return true
    }

    fun getFavorite() = sharedPref.getString(FAVORITE, "")
}