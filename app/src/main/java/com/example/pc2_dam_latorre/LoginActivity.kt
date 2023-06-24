package com.example.pc2_dam_latorre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var db = FirebaseFirestore.getInstance()

        val etDNI = findViewById<EditText>(R.id.etDNI)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener{
            startActivity(Intent(this,RegistroActivity::class.java))
        }

        btnLogin.setOnClickListener{
            val etDNI = etDNI.text.toString()
            val etPassword = etPassword.text.toString()
            db.collection("user")
                .whereEqualTo("Clave", etPassword)
                .whereEqualTo("dni",etDNI)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val querySnapshot = task.result
                        if (querySnapshot != null && !querySnapshot.isEmpty) {
                            Toast.makeText(
                                applicationContext,
                                "ACCESO PERMITIDO",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "EL USUARIO Y/O CLAVE NO EXISTE EN EL SISTEMA",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Error de base de datos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }
}
