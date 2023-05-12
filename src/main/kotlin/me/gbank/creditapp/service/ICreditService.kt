package me.gbank.creditapp.service

import me.gbank.creditapp.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(CustomerId: Long): List<Credit>

    fun findByCredit(creditCode: UUID): Credit
}