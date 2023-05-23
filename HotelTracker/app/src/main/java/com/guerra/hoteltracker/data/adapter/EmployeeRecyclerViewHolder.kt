package com.guerra.hoteltracker.data.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.guerra.hoteltracker.data.model.EmployeeModel
import com.guerra.hoteltracker.databinding.FragmentItemEmployeeBinding

class EmployeeRecyclerViewHolder(private val binding: FragmentItemEmployeeBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(
        employee: EmployeeModel, clickListener: (EmployeeModel)->Unit
    ){
        binding.textViewName.text = employee.name + " " + employee.lastName
        binding.textViewEmail.text = employee.email

        binding.cardItem.setOnClickListener{
            clickListener(employee)
        }
    }
}