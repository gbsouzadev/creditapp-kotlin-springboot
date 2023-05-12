package me.gbank.creditapp.service.impl

import me.gbank.creditapp.entity.Customer
import me.gbank.creditapp.repository.CustomerRepository
import me.gbank.creditapp.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val CustomerRepository: CustomerRepository) : ICustomerService {

    override fun save(Customer: Customer): Customer = this.CustomerRepository.save(Customer)

    override fun findById(id: Long): Customer = this.CustomerRepository.findById(id).orElseThrow {
        throw RuntimeException("Id $id not found")
    }

    override fun delete(id: Long) = this.CustomerRepository.deleteById(id)

}