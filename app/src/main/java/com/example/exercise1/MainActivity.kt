package com.example.exercise1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
            val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
            val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
            val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

            val textLoan = findViewById<TextView>(R.id.textViewLoan)
            val textInterest = findViewById<TextView>(R.id.textViewInterest)
            val textMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

            val carPNum = carPrice.text.toString().toDouble()
            val downPNum = downPayment.text.toString().toDouble()
            val loanPNum = loanPeriod.text.toString().toDouble()
            val interestRNum = interestRate.text.toString().toDouble()


            val carLoan = carPNum - downPNum
            val carInterest = carLoan * interestRNum * loanPNum
            val monthlyRepayment = (carLoan + carInterest)/loanPNum/12

            textLoan.setText(String.format("Loan : %.2f", carLoan))
            textInterest.setText(String.format("Interest : %.2f", carInterest))
            textMonthlyRepayment.setText(String.format("Monthly Repayment : %.2f", monthlyRepayment))
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
            val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
            val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
            val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

            val textLoan = findViewById<TextView>(R.id.textViewLoan)
            val textInterest = findViewById<TextView>(R.id.textViewInterest)
            val textMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

            carPrice.setText("")
            downPayment.setText("")
            loanPeriod.setText("")
            interestRate.setText("")

            textLoan.setText("Loan : ")
            textInterest.setText("Interest : ")
            textMonthlyRepayment.setText("Monthly Repayment : ")
        }
    }


}
