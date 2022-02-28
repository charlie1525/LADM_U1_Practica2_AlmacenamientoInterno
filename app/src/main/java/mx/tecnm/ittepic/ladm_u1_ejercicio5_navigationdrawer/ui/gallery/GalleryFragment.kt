package mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_gallery.*
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.ModelAdapter
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.Modelos
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.R
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.databinding.FragmentGalleryBinding
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.databinding.ModelosLayoutBinding

class GalleryFragment : Fragment() {

    var modelo1 = Modelos(R.drawable.dressuno); var modelo2 = Modelos(R.drawable.dressdos);var modelo3 = Modelos(R.drawable.dresstres)
    var modelo4 = Modelos(R.drawable.dresscuatro); var modelo5 = Modelos(R.drawable.dressfive);var modelo6 = Modelos(R.drawable.dresssix)
    var modelo7 = Modelos(R.drawable.dressseven); var modelo8 = Modelos(R.drawable.dresseight);var modelo9 = Modelos(R.drawable.dressnine)
    var modelo10 = Modelos(R.drawable.dressten); var modelo11 = Modelos(R.drawable.dresseleven);var modelo12 = Modelos(R.drawable.dresstwelve)

    val imagenModelos = listOf(modelo1,modelo2,modelo3,modelo4,modelo5,modelo6,modelo7,modelo8,modelo9,modelo10,modelo11,modelo12)

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val rootGaleriaFragment: View = binding.root

        var ListModelAdapter = ModelAdapter(requireContext(),imagenModelos)
        binding.listviewModelos.adapter = ListModelAdapter


        return rootGaleriaFragment
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}