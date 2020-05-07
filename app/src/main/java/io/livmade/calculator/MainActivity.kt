package io.livmade.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //number values
        oneBtn.setOnClickListener { addToExpression("1", canClear = true)}
        twoBtn.setOnClickListener { addToExpression("2", canClear = true)}
        threeBtn.setOnClickListener { addToExpression("3", canClear = true)}
        fourBtn.setOnClickListener { addToExpression("4", canClear = true)}
        fiveBtn.setOnClickListener { addToExpression("5", canClear = true)}
        sixBtn.setOnClickListener { addToExpression("6", canClear = true)}
        sevenBtn.setOnClickListener { addToExpression("7", canClear = true)}
        eightBtn.setOnClickListener { addToExpression("8", canClear = true)}
        nineBtn.setOnClickListener { addToExpression("9", canClear = true)}
        zeroBtn.setOnClickListener { addToExpression("0", canClear = true)}
        decimalBtn.setOnClickListener { addToExpression(".", canClear = true)}

        //Operators
        plusBtn.setOnClickListener { addToExpression("+", canClear = true)}
        minusBtn.setOnClickListener { addToExpression("-", canClear = true)}
        multiplyBtn.setOnClickListener { addToExpression("*", canClear = true)
        "×" == "*"}
        divideBtn.setOnClickListener { addToExpression("/", canClear = true)
         "÷" == "/"}

        //Functionals
        clearBtn.setOnClickListener {
            expression.text = ""
            expressResult.text = ""
        }

        delBtn.setOnClickListener {
            var num = expression.text.toString()
            if(num.isNotEmpty()) {
                expression.text = num.substring(0,num.length-1)
            }
            expressResult.text = ""
        }
        equalBtn.setOnClickListener {
            try {
                val numExpress = ExpressionBuilder(expression.text.toString()).build()
                val numEval = numExpress.evaluate()
                val longResult = numEval.toLong()
                expression.text = ""
                if(numEval == longResult.toDouble()) {
                    expressResult.text = longResult.toString()
                } else {
            expression.text = ""
            expressResult.text = numEval.toString() }
        }
            catch (e:Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

    fun addToExpression ( string: String, canClear: Boolean) {

        if (expressResult.text.isNotEmpty()) {
            expression.text = ""
        }

        if (canClear) {
            expressResult.text = ""
        } else
            expression.append(expressResult.text)
            expression.append(string)
            expressResult.text = ""
    }
}
