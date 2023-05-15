package me.gbank.creditapp.dto

import jakarta.persistence.*
import me.gbank.creditapp.entity.Credit
import me.gbank.creditapp.entity.Customer
import me.gbank.creditapp.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
