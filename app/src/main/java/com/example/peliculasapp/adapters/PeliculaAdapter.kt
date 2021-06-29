package com.example.NoteApp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.NoteApp.entity.Pelicula
import com.example.peliculasapp.DetailPelicula
import com.example.peliculasapp.R
import com.example.peliculasapp.databinding.CardviewPeliculaBinding
import com.example.peliculasapp.databinding.ParentRecyclerviewItemsBinding
import com.squareup.picasso.Picasso


class PeliculaAdapter(private val categorias: List<String> , private val peliculas: List<Pelicula>)
    : RecyclerView.Adapter<PeliculaAdapter.ViewHolder>(){

    private lateinit var myAdapter: PeliculaChildAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recyclerview_items,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.titulo.text = categorias[position]

        holder.childRecyclerview.layoutManager = GridLayoutManager(holder.itemView.context,1, RecyclerView.HORIZONTAL,false)
        holder.childRecyclerview.setHasFixedSize(true)

        myAdapter= PeliculaChildAdapter(peliculas)
        holder.childRecyclerview.adapter = myAdapter





    }

    override fun getItemCount(): Int {
        return categorias.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var binding = ParentRecyclerviewItemsBinding.bind(itemView)

        val childRecyclerview = binding.recyclerviewPeliculasChild
        val titulo = binding.tvTitulo



    }


}