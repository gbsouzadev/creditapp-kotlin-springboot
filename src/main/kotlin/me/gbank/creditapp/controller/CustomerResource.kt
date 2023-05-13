package me.gbank.creditapp.controller

import me.gbank.creditapp.dto.CustomerDto
import me.gbank.creditapp.dto.CustomerView
import me.gbank.creditapp.dto.CustumerUpdateDto
import me.gbank.creditapp.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerService: CustomerService) {

    @PostMapping
    fun savedCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Custumer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id")
    fun delete(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustumerUpdateDto) : CustomerView {
        val customer = this.customerService.findById(id)
        val costumerToUpdate = customerUpdateDto.toEntity(customer)
        val updatedCostumer = this.customerService.save(costumerToUpdate)
        return CustomerView(updatedCostumer)

    }

}