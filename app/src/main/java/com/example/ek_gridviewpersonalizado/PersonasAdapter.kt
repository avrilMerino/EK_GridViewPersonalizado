package com.example.ek_gridviewpersonalizado

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PersonasAdapter (
    context: Context,
    private val lista: ArrayList<Personas>
): ArrayAdapter<Personas>(context, 0, lista){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //1º- Reutilizar la fila o crear una nueva (aqui se une con item_persona.xml)
        val vista = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_persona, parent, false)
        //2- Persona actual:
        val persona = lista[position]

        //3º- Referencias a los elementos de item_persona.xml
        val imgAvatar = vista.findViewById<ImageView>(R.id.imgAvatar)
        val tvNombre = vista.findViewById<TextView>(R.id.tvNombre)
        val tvApellido = vista.findViewById<TextView>(R.id.tvApellidos)
        val tvCiclo = vista.findViewById<TextView>(R.id.tvCiclo)

        //4º- Rellenar textos
        tvNombre.text = persona.nombre
        tvApellido.text = persona.apellidos
        tvCiclo.text = persona.ciclo

        //5º- Avatar según el sexo
        if(persona.sexo.lowercase() == "mujer"){
            imgAvatar.setImageResource(R.drawable.mujer)
        }else{
            imgAvatar.setImageResource(R.drawable.hombre)
        }
        return vista
    }
}