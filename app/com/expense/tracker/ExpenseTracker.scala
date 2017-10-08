package com.expense.tracker

class ExpenseTracker(totalAmount: Int = 0) {

  def add(expenses: Expense*) = {
    def addExpense = (a: Expense, e: Expense) => new Expense(a.price + e.price)
    new ExpenseTracker(expenses.toList.reduce(addExpense).price)
  }

  def getTotalAmount: Int = {
    this.totalAmount
  }
}
