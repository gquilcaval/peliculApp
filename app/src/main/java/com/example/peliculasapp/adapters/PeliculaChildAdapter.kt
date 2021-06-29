package com.example.NoteApp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.NoteApp.entity.Pelicula
import com.example.peliculasapp.DetailPelicula
import com.example.peliculasapp.R
import com.example.peliculasapp.databinding.CardviewPeliculaBinding


class PeliculaChildAdapter(private val peliculas: List<Pelicula>)
    : RecyclerView.Adapter<PeliculaChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_pelicula,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        Glide.with(holder.itemView.context).load(peliculas[position].foto.toString()).into(holder.foto);
        //Picasso.get().load(peliculas[position].foto.toString()).into(holder.foto);
        holder.cardview.setOnClickListener{

            val intent = Intent(holder.itemView.context, DetailPelicula::class.java)

            intent.putExtra("nombre",  peliculas[position].nombre.toString())
            intent.putExtra("sinopsis",  peliculas[position].sinopsis.toString())
            intent.putExtra("video",  peliculas[position].video)

            startActivity(holder.itemView.context,intent,null)
        }




    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        var binding = CardviewPeliculaBinding.bind(itemView)


        val foto = binding.imgFoto
        val cardview = binding.cardviewPelicula


    }


}