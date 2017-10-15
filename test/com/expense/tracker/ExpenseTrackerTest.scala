package com.expense.tracker

import com.expense.tracker
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatestplus.play._

class ExpenseTrackerTest extends PlaySpec with OneAppPerTest {

  "Expense tracker" should  {
    "return 0 amount when initialized" in  {
      val expenseTracker = ExpenseTracker()

      expenseTracker.totalAmount mustBe 0
    }

    "return 0 amount when no expenses to add" in  {
      val expenseTracker = ExpenseTracker()

      val trackerAfterAddition = expenseTracker.add()

      trackerAfterAddition.totalAmount mustBe 0
    }

    "add an expense and reflect the total amount" in {
      val expenseTracker = ExpenseTracker()

      val expenseAfterAddition = expenseTracker.add(Expense(100))

      expenseAfterAddition.totalAmount mustBe 100
    }

    "add multiple expenses and reflect in the total amount" in {
      val expenseTracker = ExpenseTracker()

      val expenseAfterTwoAdditions = expenseTracker.add(
        Expense(100),
        Expense(200)
      )

      expenseAfterTwoAdditions.totalAmount mustBe 300
    }

    "allow the expense to be categorised" in {
      val expenseTracker = ExpenseTracker()

      val expensesForFood = expenseTracker.add(
        Expense(100, "Food"),
        Expense(200, "Food"),
        Expense(2000, "Electronics")
      ).getExpensesFor("Food")

      expensesForFood should equal(List(Expense(100, "Food"), Expense(200, "Food")))
    }
  }

}
