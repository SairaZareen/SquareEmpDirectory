package com.skz.squareempdirectory.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.skz.squareempdirectory.data.model.Employee
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao : EmployeeDAO
    private lateinit var database: EmployeeDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            EmployeeDatabase::class.java
        ).build()
        dao = database.employeeDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMovieTest() = runBlocking {
        val employees = listOf(
            Employee("bio1","email1","type1","name1","phone1","url1","smallUrl1","team1","uuid1"),
            Employee("bio2","email2","type2","name2","phone2","url2","smallUrl2","team2","uuid2"),
            Employee("bio3","email3","type3","name3","phone3","url3","smallUrl3","team3","uuid3")
        )
        dao.saveEmployee(employees)

        val allEmployees = dao.getEmployees()
        Truth.assertThat(allEmployees).isEqualTo(employees)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val employees = listOf(
            Employee("bio1","email1","type1","name1","phone1","url1","smallUrl1","team1","uuid1"),
            Employee("bio2","email2","type2","name2","phone2","url2","smallUrl2","team2","uuid2"),
            Employee("bio3","email3","type3","name3","phone3","url3","smallUrl3","team3","uuid3")
        )
        dao.saveEmployee(employees)
        dao.deleteAllEmployees()
        val employeesResult = dao.getEmployees()
        Truth.assertThat(employeesResult).isEmpty()
    }
}