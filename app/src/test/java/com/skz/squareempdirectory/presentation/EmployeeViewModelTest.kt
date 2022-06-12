package com.skz.squareempdirectory.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.data.repository.FakeEmployeeRepository
import com.skz.squareempdirectory.domain.usecase.GetEmployeeUseCase
import com.skz.squareempdirectory.domain.usecase.UpdateEmployeeUseCase
import com.skz.squareempdirectory.getOrAwaitValue

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmployeeViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel : EmployeeViewModel

    @Before
    fun setUp() {
        val fakeEmployeeRepository = FakeEmployeeRepository()
        val getEmployeeUseCase = GetEmployeeUseCase(fakeEmployeeRepository)
        val updateEmployeeUseCase = UpdateEmployeeUseCase(fakeEmployeeRepository)
        viewModel = EmployeeViewModel(getEmployeeUseCase,updateEmployeeUseCase)

    }

    @Test
    fun getEmployees_returnsCurrentList(){
        val employees = mutableListOf<Employee>()
        employees.add(Employee("bio1","email1","type1","name1","phone1","url1","smallUrl1","team1","uuid1"))
        employees.add(Employee("bio2","email2","type2","name2","phone2","url2","smallUrl2","team2","uuid2"))

        val currentList = viewModel.getEmployees().getOrAwaitValue()
        assertThat(currentList).isEqualTo(employees)


    }

    @Test
    fun updateEmployees_returnsUpdatedList(){
        val employees = mutableListOf<Employee>()
        employees.add(Employee("bio3","email3","type3","name3","phone3","url3","smallUrl3","team3","uuid3"))
        employees.add(Employee("bio4","email4","type4","name4","phone4","url4","smallUrl4","team4","uuid4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(employees)


    }
}