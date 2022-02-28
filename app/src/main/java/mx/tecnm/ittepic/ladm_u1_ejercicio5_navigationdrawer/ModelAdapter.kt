package mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.modelos_layout.view.*

class ModelAdapter(private val contexto: Context, private val listaModelos: List<Modelos>) : ArrayAdapter<Modelos>(contexto,0,listaModelos) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout =LayoutInflater.from(contexto).inflate(R.layout.modelos_layout, parent, false)
        var ModeloA = listaModelos[position]
        layout.imagenModelo.setImageResource(ModeloA.imagen)

        return layout
    }
}