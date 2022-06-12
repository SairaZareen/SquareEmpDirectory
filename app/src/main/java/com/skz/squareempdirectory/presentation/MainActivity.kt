package com.skz.squareempdirectory.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skz.squareempdirectory.R
import com.skz.squareempdirectory.databinding.ActivityMainBinding
import com.skz.squareempdirectory.presentation.di.Injector
import java.io.IOException
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: EmployeeViewModelFactory
    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        (application as Injector).createEmployeeSubComponent().inject(this)

        employeeViewModel = ViewModelProvider(this,factory).get(EmployeeViewModel::class.java)
        initRecyclerView()
    }


    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        employeeAdapter = EmployeeAdapter()
        binding.recyclerView.adapter = employeeAdapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.empProgressBar.visibility = View.VISIBLE
        val responseLiveData = employeeViewModel.getEmployees()
        responseLiveData.observe(this, Observer {
           // Log.i("MYTAG",it.toString())
            if(it!=null){
                employeeAdapter.setList(it)
                employeeAdapter.notifyDataSetChanged()
                binding.empProgressBar.visibility = View.GONE
            }else{
                binding.empProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateEmployees()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateEmployees(){
        binding.empProgressBar.visibility = View.VISIBLE
        val response = employeeViewModel.updateEmployees()
        response.observe(this, Observer {
            if (it!= null){
                employeeAdapter.setList(it)
                employeeAdapter.notifyDataSetChanged()
                binding.empProgressBar.visibility = View.GONE
            }else{
                binding.empProgressBar.visibility = View.GONE
                try {
                    Log.v("Tag", "Error")
                    Toast.makeText(this,"No network connection!",Toast.LENGTH_SHORT).show()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        })
    }
}