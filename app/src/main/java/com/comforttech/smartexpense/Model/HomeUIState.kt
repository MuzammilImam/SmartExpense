package com.comforttech.smartexpense.Model

data class HomeUIState(

    val insights: List<Insight> = emptyList(),

    val recentExpenses: List<Expense> = emptyList()
)
