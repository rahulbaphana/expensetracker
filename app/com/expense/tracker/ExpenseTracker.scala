package com.expense.tracker

case class ExpenseTracker(totalAmount: Int = 0) {
  def getExpensesFor(category: String): List[Expense] = ???


  def add(expenses: Expense*) = {
    expenses.toList match {
      case h :: t => ExpenseTracker(expenses.toList.reduce((a,b) => Expense(a.price + b.price)).price)
      case _ => ExpenseTracker()
    }
  }
}
