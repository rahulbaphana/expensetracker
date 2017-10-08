package com.expense.tracker

import com.expense.tracker.ExpenseTracker
import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class ExpenseTrackerTest extends PlaySpec with OneAppPerTest {

  "Expense tracker" should  {
    "empty should return 0 amount" in  {
      val expenseTracker = new ExpenseTracker()

      assert(expenseTracker.getTotalAmount == 0)
    }

    "adding an expense should reflect the total amount" in {
      val expenseTracker = new ExpenseTracker()

      val expenseAfterAddition = expenseTracker.add(new Expense(100))

      assert(expenseAfterAddition.getTotalAmount == 100)
    }

    "adding multiple expenses should be reflected in the total amount" in {
      val expenseTracker = new ExpenseTracker()

      val expenseAfterTwoAdditions = expenseTracker.add(
        new Expense(100),
        new Expense(200)
      )

      assert(expenseAfterTwoAdditions.getTotalAmount == 300)
    }
  }

}
