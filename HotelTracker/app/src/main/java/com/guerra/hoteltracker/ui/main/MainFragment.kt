package com.guerra.hoteltracker.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guerra.hoteltracker.data.adapter.EmployeeRecyclerViewAdapter
import com.guerra.hoteltracker.data.model.EmployeeModel
import com.guerra.hoteltracker.R
import com.guerra.hoteltracker.databinding.FragmentMainBinding
import com.guerra.hoteltracker.ui.viewmodel.EmployeeViewModel


/**
Main application view
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: EmployeeRecyclerViewAdapter

    private val employeeViewModel: EmployeeViewModel by activityViewModels{
        EmployeeViewModel.Factory
    }
    //ya
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    //ya
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        listeners()
        recyclerView(view)
    }
    //ya
    private fun listeners() {
        binding.btnAddEmployee.setOnClickListener{
            employeeViewModel.clearData()
            it.findNavController().navigate(R.id.action_mainFragment3_to_formFragment)
        }
    }

    private fun showSelectedItem(employee: EmployeeModel){
        employeeViewModel.setSelectedEmployee(employee)
        findNavController().navigate(R.id.action_mainFragment3_to_viewEmployeeFragment)
    }

    private fun displayEmployees(){
        adapter.setData(employeeList = employeeViewModel.getEmployees())
        adapter.notifyDataSetChanged()
    }

    private fun recyclerView(view: View){
        binding.recyleViewEmployee.layoutManager = LinearLayoutManager(view.context)

        adapter = EmployeeRecyclerViewAdapter { selectedEmployee ->
            showSelectedItem(selectedEmployee)
        }

        binding.recyleViewEmployee.adapter = adapter
        displayEmployees()
    }

    //ya
    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())
        val toast = Toast.makeText(requireContext(), "works", Toast.LENGTH_SHORT)
        toast.show()
        if(navController.currentDestination?.id != R.id.mainFragment3){
            navController.popBackStack()
        }
        else requireActivity().onBackPressed()
    }
}