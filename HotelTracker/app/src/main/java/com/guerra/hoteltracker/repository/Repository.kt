package com.guerra.hoteltracker.repository

import com.guerra.hoteltracker.data.model.EmployeeModel

class Repository (private val employees: MutableList<EmployeeModel>) {
    fun getEmployees () = employees

    fun setEmployee (employee: EmployeeModel) = employees.add(employee)
}
//Primero se obtiene los empleados de la lista mutable que proviene del Model y luego se guardan en employess
//Para mantenerse en el repositorio y jugar con la data