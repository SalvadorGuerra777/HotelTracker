package com.guerra.hoteltracker

import android.app.Application
import com.guerra.hoteltracker.data.model.employees
import com.guerra.hoteltracker.repository.Repository

class EmployeeReviewerApplication: Application() {

    val employeeRepository: Repository by lazy {
        Repository(employees)
    }
}