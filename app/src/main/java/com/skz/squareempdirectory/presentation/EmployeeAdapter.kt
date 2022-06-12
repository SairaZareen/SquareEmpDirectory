package com.skz.squareempdirectory.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skz.squareempdirectory.R
import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.databinding.EmployeeItemBinding

class EmployeeAdapter : RecyclerView.Adapter<MyViewHolder>(){
    private val employeeList = ArrayList<Employee>()

    fun setList(employees:List<Employee>){
        employeeList.clear()
        employeeList.addAll(employees)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : EmployeeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.employee_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}


class MyViewHolder(val binding: EmployeeItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(employee:Employee){
        binding.nameTextView.text = employee.fullName
        binding.teamTextView.text = employee.team

        val posterURL = employee.photoUrlSmall
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}