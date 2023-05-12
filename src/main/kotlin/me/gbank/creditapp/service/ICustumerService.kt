package me.gbank.creditapp.service

import me.gbank.creditapp.entity.Customer

interface ICustomerService {

    fun save(Customer: Customer): String

    fun findById(id: Long): Customer

    fun delete(id: Long)
}