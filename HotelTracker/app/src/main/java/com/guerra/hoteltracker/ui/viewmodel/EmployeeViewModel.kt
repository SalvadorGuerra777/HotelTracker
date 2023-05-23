package com.guerra.hoteltracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guerra.hoteltracker.data.model.EmployeeModel
import com.guerra.hoteltracker.EmployeeReviewerApplication
import com.guerra.hoteltracker.repository.Repository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

class EmployeeViewModel (private val repository: Repository): ViewModel() {
    val Name = MutableLiveData("")
    val lastName = MutableLiveData("")
    val Email = MutableLiveData("")
    val Description = MutableLiveData("")
    val status = MutableLiveData("")

    fun getEmployees () = repository.getEmployees()

    private fun addEmployee (employee: EmployeeModel) = repository.setEmployee(employee)

    private fun validateData(): Boolean{
        when{
            Name.value.isNullOrBlank() -> return false
            lastName.value.isNullOrBlank() -> return false
            Email.value.isNullOrBlank() -> return false
            Description.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun createEmployee(): String{
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return WRONG_INFORMATION
        }
        val employee = EmployeeModel(
            name = Name.value!!,
            lastName = lastName.value!!,
            email = Email.value!!,
            description = Description.value!!
        )

        addEmployee(employee)
        status.value = EMPLOYEE_ADDED

        return EMPLOYEE_ADDED
    }

    fun clearData(){
        Name.value = ""
        lastName.value = ""
        Email.value = ""
        Description.value = ""
    }

    fun clearStatus (){
        status.value = INACTIVE
    }

    fun setSelectedEmployee(employee: EmployeeModel){
        Name.value = employee.name
        lastName.value = employee.lastName
        Email.value = employee.email
        Description.value = employee.description
    }

    companion object{

        val Factory = viewModelFactory {
            initializer {
                val employeeRepository = (this[APPLICATION_KEY] as EmployeeReviewerApplication).employeeRepository
                EmployeeViewModel(employeeRepository)
            }
        }

        const val EMPLOYEE_ADDED  = "employee added to database"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}