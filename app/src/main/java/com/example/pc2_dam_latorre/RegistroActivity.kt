package com.example.pc2_dam_latorre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val etDNIRegistro = findViewById<EditText>(R.id.etDNIRegistro)
        val etPasswordRegistro = findViewById<EditText>(R.id.etPasswordRegistro)
        val etPasswordRepetition = findViewById<EditText>(R.id.etPasswordRepetition)
        val etNombreRegistro = findViewById<EditText>(R.id.etPasswordRegistro)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("users")

        btnRegistro.setOnClickListener{
            val DNI = etDNIRegistro.text.toString()
            val Nombre = etNombreRegistro.text.toString()


            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}