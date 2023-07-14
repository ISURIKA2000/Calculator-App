package com.example.calculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the text views for the result and solution
        val resultText : TextView = findViewById(R.id.result_tv)
        val solutionText : TextView = findViewById(R.id.solution_tv)

        // Get the buttons LinearLayout
        val buttonsLayout : LinearLayout = findViewById(R.id.buttons_layout)

        // Get the Clear button in the buttons LinearLayout
        val clearButton : Button = buttonsLayout.findViewById(R.id.clear_button)
        val AllClear : Button = buttonsLayout.findViewById(R.id.button_ac)

        // Set the onClickListener for the Clear button
        clearButton.setOnClickListener {
            // Clear the last character
            if (resultText.text.toString().isNotEmpty()) {
                resultText.text = resultText.text.toString().substring(0, resultText.text.toString().length - 1)
            }
        }

        // Set the onClickListener for the AC button
        AllClear.setOnClickListener {
            // Clear the result and solution
            resultText.text = "0"
            solutionText.text = ""
        }

        // Get the parentheses buttons in the buttons LinearLayout
        val leftParenthesesButton : Button = buttonsLayout.findViewById(R.id.button_open_bracket)
        val rightParenthesesButton : Button = buttonsLayout.findViewById(R.id.button_close_bracket)

        // Get the numbers buttons in the buttons LinearLayout
        val zeroButton : Button = buttonsLayout.findViewById(R.id.button_0)
        val oneButton : Button = buttonsLayout.findViewById(R.id.button_1)
        val twoButton : Button = buttonsLayout.findViewById(R.id.button_2)
        val threeButton : Button = buttonsLayout.findViewById(R.id.button_3)
        val fourButton : Button = buttonsLayout.findViewById(R.id.button_4)
        val fiveButton : Button = buttonsLayout.findViewById(R.id.button_5)
        val sixButton : Button = buttonsLayout.findViewById(R.id.button_6)
        val sevenButton : Button = buttonsLayout.findViewById(R.id.button_7)
        val eightButton : Button = buttonsLayout.findViewById(R.id.button_8)
        val nineButton : Button = buttonsLayout.findViewById(R.id.button_9)
        val decimalButton : Button = buttonsLayout.findViewById(R.id.button_dot)

        // Get the operators buttons in the buttons LinearLayout
        val plusButton : Button = buttonsLayout.findViewById(R.id.button_plus)
        val minusButton : Button = buttonsLayout.findViewById(R.id.button_minus)
        val multiplyButton : Button = buttonsLayout.findViewById(R.id.button_multiply)
        val divideButton : Button = buttonsLayout.findViewById(R.id.button_divide)

        // Get the equal button in the buttons LinearLayout
        val equalButton : Button = buttonsLayout.findViewById(R.id.button_equals)

        val setTextInView = { _text: String ->
            // Set the text in the result text view
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()

            resultText.append(_text)
        }

        // Set the onClickListener for the numbers buttons
        zeroButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                return@setOnClickListener
            }
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("0")
        }
        oneButton.setOnClickListener {setTextInView("1")}
        twoButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("2")
        }
        threeButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("3")
        }
        fourButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("4")
        }
        fiveButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("5")
        }
        sixButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("6")
        }
        sevenButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("7")
        }
        eightButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("8")
        }
        nineButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("9")
        }
        decimalButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append(".")
        }

        // Set the onClickListener for the operators buttons
        plusButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("+")
        }
        minusButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("-")
        }
        multiplyButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("*")
        }
        divideButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("/")
        }

        // Set the onClickListener for the parentheses buttons
        leftParenthesesButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append("(")
        }
        rightParenthesesButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append(")")
        }

        // Set the onClickListener for the decimal button
        decimalButton.setOnClickListener {
            if (resultText.text.toString() == "0") {
                // Remove the 0
                resultText.text = ""
            }
            clearInError()
            resultText.append(".")
        }

        // Set the onClickListener for the equal button
        equalButton.setOnClickListener {
            // Get the result and solution
            val result = resultText.text.toString()
            val solution = calculate(result)
            //If resultText is not red, set the result and solution
            if (resultText.currentTextColor != Color.RED) {
                resultText.text = solution
                solutionText.text = result


            }else{
                // If resultText is red, set the result and solution to empty
                resultText.text = solution
            }
        }
    }

    private fun clearInError() {
        // Clear the result and solution
        val resultText : TextView = findViewById(R.id.result_tv)
        val solutionText : TextView = findViewById(R.id.solution_tv)
        // If resultText is red, set the result and solution to empty
        if (resultText.currentTextColor == Color.RED) {
            resultText.text = ""
            solutionText.text = ""
            solutionText.setTextColor(Color.WHITE)
        }
        // Make the resultText black and Set the size of the resultText to 40sp
        resultText.setTextColor(Color.WHITE)
        resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
    }

    private fun calculate(result: String): String {
        // Evaluate the result using the Expression library
        return try {
            val expression = ExpressionBuilder(result).build()
            val solution = expression.evaluate()
            if (solution % 1 == 0.0) {
                // If the solution is a whole number, don't show the decimal point
                solution.toInt().toString()
            } else {
                // If the solution is not a whole number, show the maximum six decimal places
                BigDecimal(solution).setScale(6, RoundingMode.HALF_EVEN).stripTrailingZeros().toString()
            }
        }catch (e: Exception) {
            val resultText : TextView = findViewById(R.id.result_tv)
            val solutionText : TextView = findViewById(R.id.solution_tv)

            // If the expression is invalid, show "Invalid Expression"
            solutionText.setTextColor(Color.RED)
            solutionText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            solutionText.text = "error"

            // Make the result text red and Font size 20sp
            resultText.setTextColor(Color.RED)
            resultText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            // If the expression is invalid, show "Invalid Expression"
            e.message.toString()
        }
    }
}