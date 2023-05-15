package me.gbank.creditapp.exception

data class BusinessException(override val message: String?) : RuntimeException(message)
