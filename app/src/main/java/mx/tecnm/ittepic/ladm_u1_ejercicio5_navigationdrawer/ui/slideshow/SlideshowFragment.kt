package mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.CustomAdapter
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.MainActivity
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.R
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.databinding.FragmentSlideshowBinding
import java.lang.Exception

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    lateinit var arreglos: CustomAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Programacion del Recycler Viwer
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerViewSlShF)
        val adapter = CustomAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // sección dedicada para la programación de los botones
        //Declaracion de las variables a usar
        arreglos = CustomAdapter()
        var btnGuardarKF = binding.btnGuardar;
        val btnLeerKF = binding.btnLeer;
        val btnModificarKF = binding.btnModificar;
        val btneliminarKF = binding.btnEliminar
        val txtNombre = binding.inputNombreLV;
        val txtMotivo = binding.inputMotivoLV;
        val txtHora = binding.inputHoraLV
        var indiceArreglo = 0

        //código para la funcionalidad de los botones

        btnGuardarKF.setOnClickListener {
            if (txtNombre.text.toString().isEmpty() || txtMotivo.text.toString()
                    .isEmpty() || txtHora.text.toString().isEmpty()
            ) {
                AlertDialog.Builder(requireContext()).setTitle("Error de guardado")
                    .setMessage("No puedes guardar campos vacios")
                    .setNeutralButton("Ok", { d, i -> }).show()
            } else {
                arreglos.nombres.set(indiceArreglo, txtNombre.text.toString())
                arreglos.motivos.set(indiceArreglo, txtMotivo.text.toString())
                arreglos.horas.set(indiceArreglo, txtHora.text.toString())
                indiceArreglo += 1
                guardarArchivo()
            }
        } // fin del boton para guardar

        btnLeerKF.setOnClickListener {
            leerArchivo()
        }

        btnModificarKF.setOnClickListener {
            if (txtNombre.text.toString().isEmpty() || txtMotivo.text.toString()
                    .isEmpty() || txtHora.text.toString().isEmpty()
            ) {
                AlertDialog.Builder(requireContext()).setTitle("Error de modificación")
                    .setMessage("Modificacion guiada por el nombre, inserte uno para poder modificar la información ")
                    .setNeutralButton("Ok", { d, i -> }).show()
            } else if (arreglos.nombres.equals(txtNombre.text.toString())) {
                val indiceInterno = arreglos.nombres.indexOf(txtNombre.text.toString())
                arreglos.nombres.set(indiceInterno, txtNombre.text.toString())
                arreglos.motivos.set(indiceInterno, txtMotivo.text.toString())
                arreglos.horas.set(indiceInterno, txtHora.text.toString())
                guardarArchivo()
            }
        }

        btneliminarKF.setOnClickListener {
            if (txtNombre.text.toString().isEmpty() || txtMotivo.text.toString()
                    .isEmpty() || txtHora.text.toString().isEmpty()
            ) {
                AlertDialog.Builder(requireContext()).setTitle("Error de eliminación")
                    .setMessage("Eliminación guiada por el nombre, inserte uno para eliminar una cita")
                    .setNeutralButton("Ok", { d, i -> }).show()
            } else if (arreglos.nombres.equals(txtNombre.text.toString())) {
                val indiceInterno = arreglos.nombres.indexOf(txtNombre.text.toString())
                arreglos.nombres.set(indiceInterno, "")
                arreglos.motivos.set(indiceInterno, "")
                arreglos.horas.set(indiceInterno, "")
                guardarArchivo()
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun guardarArchivo() {
        try {

            var cadena = arreglos.nombres[arreglos.nombres.lastIndex] + "\n" +
                    arreglos.motivos[arreglos.motivos.lastIndex] + "\n" +
                    arreglos.horas[arreglos.horas.lastIndex] + "\n"

            val archivoEscritura =
                requireContext().openFileOutput("Archivo.txt", AppCompatActivity.MODE_PRIVATE)
           archivoEscritura.bufferedWriter().append(cadena)
            Toast.makeText(
                requireContext(),
                "Se guardo el archivo correctamente",
                Toast.LENGTH_SHORT
            ).show()
        } catch (a: Exception) {
            AlertDialog.Builder(requireContext()).setMessage(a.message).show()
        }
    } // fin de la función

    fun leerArchivo() {
        try {

            var cadena = ""
            val archivoLectura = requireContext().openFileInput("Archivo.txt")
            archivoLectura.bufferedReader()
                .forEachLine {
                    cadena = cadena + " " + archivoLectura.bufferedReader().readLine()
                }

            AlertDialog.Builder(requireContext()).setMessage(cadena).show()
        } catch (a: Exception) {
            AlertDialog.Builder(requireContext()).setMessage(a.message).show()
        }
    } // fin de la función

}