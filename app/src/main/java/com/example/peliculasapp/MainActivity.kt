package com.example.peliculasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.NoteApp.adapters.PeliculaAdapter
import com.example.NoteApp.adapters.PeliculaChildAdapter
import com.example.NoteApp.entity.Pelicula
import com.example.peliculasapp.databinding.ActivityMainBinding
import com.google.firebase.firestore.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var myAdapter: PeliculaAdapter
     var categorias: ArrayList<String> =arrayListOf()
    private lateinit var peliculasArray: ArrayList<Pelicula>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        categorias.add("ESTRENOS")
        categorias.add("LO MAS NUEVO")
        categorias.add("TERROR")
        categorias.add("ACCION")
        categorias.add("COMEDIA")
        categorias.add("CIENCIA FICCION")
        categorias.add("DOCUMENTALES")

        doAsync {
            // Specify layout for recycler view
            binding.recyclerviewPeliculasParent.layoutManager = GridLayoutManager(applicationContext,1, RecyclerView.VERTICAL,false)
            binding.recyclerviewPeliculasParent.setHasFixedSize(true)

            peliculasArray = arrayListOf()

            myAdapter = PeliculaAdapter(categorias,peliculasArray)
            binding.recyclerviewPeliculasParent.adapter = myAdapter

        }



        EventChangeListener()


/*   val mediaController =  MediaController(this)
                mediaController.setAnchorView(binding.videoView)
                val url = Uri.parse(document.data["video"].toString())

                binding.videoView.setMediaController(mediaController)
                binding.videoView.setVideoURI(url)
                binding.videoView.requestFocus()
                binding.videoView.start()*/


    }


    private fun EventChangeListener(){

        db.collection("peliculas").addSnapshotListener(object : EventListener<QuerySnapshot> {

            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if (error != null) {

                }
                for (dc: DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED){

                    peliculasArray.add(dc.document.toObject(Pelicula::class.java))
                    }

                }
                myAdapter.notifyDataSetChanged()


            }


        })

    }
}