package com.guerra.hoteltracker.repository

import com.guerra.hoteltracker.data.model.EmployeeModel

class Repository (private val employees: MutableList<EmployeeModel>) {
    fun getEmployees () = employees

    fun setEmployee (employee: EmployeeModel) = employees.add(employee)
}