package com.example.peliculasapp

import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.peliculasapp.databinding.ActivityDetailPeliculaBinding
import com.google.firebase.firestore.FirebaseFirestore


class DetailPelicula : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pelicula)
        val binding = ActivityDetailPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)




        // INTENTS
        val bundle = intent.extras
        val nombre = bundle?.getString("nombre")
        val sinopsis = bundle?.getString("sinopsis")
        val video = bundle?.getString("video")

        binding.tvNombre.text = nombre
        binding.tvSinopsis.text = sinopsis
        val mediaController =  MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        val url = Uri.parse(video)

        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoURI(url)
        binding.videoView.requestFocus()
        binding.videoView.start()

    }
}