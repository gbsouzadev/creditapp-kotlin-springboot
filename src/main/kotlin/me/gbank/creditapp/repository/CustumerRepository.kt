package me.gbank.creditapp.repository

import me.gbank.creditapp.entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustumerRepository: JpaRepository<Custumer, Long>