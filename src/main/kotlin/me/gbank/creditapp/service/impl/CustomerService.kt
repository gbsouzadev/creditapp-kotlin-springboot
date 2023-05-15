package me.gbank.creditapp.service.impl

import me.gbank.creditapp.entity.Customer
import me.gbank.creditapp.exception.BusinessException
import me.gbank.creditapp.repository.CustomerRepository
import me.gbank.creditapp.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(Customer: Customer): Customer = this.customerRepository.save(Customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        val customer : Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}