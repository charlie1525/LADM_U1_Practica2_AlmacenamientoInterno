package mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    public val nombres = arrayOf("", "", "", "", "", "", "", "", "", "", "", "")
    public val motivos = arrayOf("", "", "", "", "", "", "", "", "", "", "", "")
    public val horas = arrayOf("", "", "", "", "", "", "", "", "", "", "", "")
    private val imagenes = arrayOf(
        R.drawable.faceone, R.drawable.facetwo, R.drawable.facethree,
        R.drawable.facefour, R.drawable.facefive, R.drawable.facesix,
        R.drawable.faceone, R.drawable.facetwo, R.drawable.facethree,
        R.drawable.facefour, R.drawable.facefive, R.drawable.facesix
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNombre.text = nombres[position]
        holder.itemMotivo.text = motivos[position]
        holder.itemHora.text = horas[position]
        if (nombres[position].isNotEmpty() && motivos[position].isNotEmpty() && horas[position].isNotEmpty()) {
            holder.itemImage.setImageResource(imagenes[position])
        }
    }

    override fun getItemCount(): Int {
        return nombres.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView;
        var itemNombre: TextView;
        var itemMotivo: TextView;
        var itemHora: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemNombre = itemView.findViewById(R.id.item_nombre)
            itemMotivo = itemView.findViewById(R.id.item_motivo)
            itemHora = itemView.findViewById(R.id.item_hora)
        }
    } // fin de la inner class

}