package com.expense.tracker

case class ExpenseTracker(totalAmount: Int = 0) {

  def add = (expenses: Expense*) => ExpenseTracker(expenses.toList.reduce((a,b) => Expense(a.price + b.price)).price)
}
