package me.gbank.creditapp.service

import me.gbank.creditapp.entity.Custumer

interface ICustumerService {

    fun save(custumer: Custumer): Custumer

    fun findById(id: Long): Custumer

    fun delete(id: Long): Custumer
}