package me.gbank.creditapp.controller

import me.gbank.creditapp.dto.CustomerDto
import me.gbank.creditapp.service.impl.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerService: CustomerService) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Custumer ${savedCustomer.email} saved!"
    }
}