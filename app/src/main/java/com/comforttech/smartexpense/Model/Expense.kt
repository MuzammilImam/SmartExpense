package com.comforttech.smartexpense.Model

data class Expense(

    val id: Int,
    val title: String,
    val category: String,
    val amount: Double,
    val dateTime: String
)
