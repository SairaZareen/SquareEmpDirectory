package com.skz.squareempdirectory.data.repository

import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.domain.repository.EmployeeRepository

class FakeEmployeeRepository : EmployeeRepository {
    private val employees = mutableListOf<Employee>()
    init{
        employees.add(Employee("bio1","email1","type1","name1","phone1","url1","smallUrl1","team1","uuid1"))
        employees.add(Employee("bio2","email2","type2","name2","phone2","url2","smallUrl2","team2","uuid2"))
    }
    override suspend fun getEmployees(): List<Employee>? {
        return employees
    }

    override suspend fun updateEmployees(): List<Employee>? {
    employees.clear()
        employees.add(Employee("bio3","email3","type3","name3","phone3","url3","smallUrl3","team3","uuid3"))
        employees.add(Employee("bio4","email4","type4","name4","phone4","url4","smallUrl4","team4","uuid4"))
        return employees
    }
}