package com.guerra.hoteltracker.ui.main.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guerra.hoteltracker.R
import com.guerra.hoteltracker.databinding.FragmentFormBinding
import com.guerra.hoteltracker.databinding.FragmentItemEmployeeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ItemEmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemEmployeeFragment : Fragment() {

    private lateinit var binding: FragmentItemEmployeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//Biding se encarga de crear el nuevo componente a partir de uno ya creado y lo implementa a la vista general
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

}