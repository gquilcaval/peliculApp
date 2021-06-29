package com.example.NoteApp.dao

import com.example.NoteApp.entity.Pelicula


interface PeliculaDao {

    fun getAll():List<Pelicula>



   /* @Insert
    suspend fun insertAll(vararg nota: Nota)

    @Update
    suspend fun update(nota: Nota)


    @Query("DELETE FROM nota WHERE uid=:id")
    suspend fun delete(id: String)*/
}