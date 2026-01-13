package com.example.ek_gridviewpersonalizado

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ek_gridviewpersonalizado.databinding.ActivityModulosBinding

class ActivityModulos : AppCompatActivity() {
    private lateinit var binding: ActivityModulosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityModulosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recojo los datos del intent:
        val ciclo = intent.getStringExtra("CICLO") ?: ""
        val nombre = intent.getStringExtra("NOMBRE") ?: ""
        val apellidos = intent.getStringExtra("APELLIDOS") ?: ""

        binding.tvCiclo.text = "$nombre $apellidos - $ciclo"

        //Personalizamos el funcion de qué ciclo
        when (ciclo) {
            "ASIR" -> {
                binding.main.setBackgroundColor(android.graphics.Color.parseColor("#b675ff"))
                binding.imgCiclo.setImageResource(R.drawable.asir)
            }

            "DAW" -> {
                binding.main.setBackgroundColor(android.graphics.Color.parseColor("#ff5436"))
                binding.imgCiclo.setImageResource(R.drawable.daw)
            }

            "DAM" -> {
                binding.main.setBackgroundColor(android.graphics.Color.parseColor("#c1ff65"))
                binding.imgCiclo.setImageResource(R.drawable.dam)
            }
        }
        //Botón de volver.
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}