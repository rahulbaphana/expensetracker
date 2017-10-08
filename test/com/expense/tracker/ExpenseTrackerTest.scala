package com.expense.tracker

import com.expense.tracker.ExpenseTracker
import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class ExpenseTrackerTest extends PlaySpec with OneAppPerTest {

  "Expense tracker" should  {
    "empty should return 0 amount" in  {
      val expenseTracker = ExpenseTracker()

      assert(expenseTracker.totalAmount == 0)
    }

    "adding an expense should reflect the total amount" in {
      val expenseTracker = ExpenseTracker()

      val expenseAfterAddition = expenseTracker.add(Expense(100))

      assert(expenseAfterAddition.totalAmount == 100)
    }

    "adding multiple expenses should be reflected in the total amount" in {
      val expenseTracker = ExpenseTracker()

      val expenseAfterTwoAdditions = expenseTracker.add(
        Expense(100),
        Expense(200)
      )

      assert(expenseAfterTwoAdditions.totalAmount == 300)
    }
  }

}
