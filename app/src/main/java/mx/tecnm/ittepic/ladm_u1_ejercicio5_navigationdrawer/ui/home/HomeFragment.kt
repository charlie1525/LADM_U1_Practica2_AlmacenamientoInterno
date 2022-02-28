package mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.R
import mx.tecnm.ittepic.ladm_u1_ejercicio5_navigationdrawer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnAcerca = binding.btnAcerca
        btnAcerca.setOnClickListener {
            val imagen = ImageView(requireContext())
            imagen.setImageResource(R.drawable.ic_baseline_timer_24)

            AlertDialog.Builder(requireContext())
                .setTitle("Acerda de...")
                .setMessage("(C) Carlos Uriel \n Tecnologico de tepic ")
                .setView(imagen)
                .setPositiveButton("ok",{d,i ->})
                .show()
        }

        return root
    }

    public fun getViewId(): Int {
        return 1;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}