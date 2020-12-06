package com.anil.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import javax.xml.xpath.XPathExpression



class CalculatorActivity : AppCompatActivity() {

    var clickOperatorFlag = true;
    var oldNumber = "";
    var myOperator = "+";

    lateinit var btnmul: Button
    lateinit var btnsub: Button
    lateinit var btndiv: Button
    lateinit var btnadd: Button
    lateinit var btneql: Button

    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    lateinit var tvplace: TextView
    lateinit var tventer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btnmul = findViewById(R.id.btnmul)
        btnsub = findViewById(R.id.btnsub)
        btndiv = findViewById(R.id.btndiv)
        btnadd = findViewById(R.id.btnplu)
        btneql = findViewById(R.id.btneql)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)

        tvplace = findViewById(R.id.tvplace)
        tventer = findViewById(R.id.tventer)


    }


    fun clickNumber(view: View) {

        if (clickOperatorFlag == true) {
            tvplace.setText("");
        }
        clickOperatorFlag = false;
        var btnClick: String = tvplace.text.toString();
        var btnSelect: Button = view as Button
        when (btnSelect.id) {
            btn1.id -> {
                btnClick += "1"
            }
            btn2.id -> {
                btnClick += "2"
            }
            btn3.id -> {
                btnClick += "3"
            }
            btn4.id -> {
                btnClick += "4"
            }
            btn5.id -> {
                btnClick += "5"
            }
            btn6.id -> {
                btnClick += "6"
            }
            btn7.id -> {
                btnClick += "7"
            }
            btn8.id -> {
                btnClick += "8"
            }
            btn9.id -> {
                btnClick += "9"
            }
            btn0.id -> {
                btnClick += "0"
            }
            btnadd.id -> {
                btnClick = "$btnClick"
            }
        }
        tvplace.setText(btnClick)
    }

    fun clickOperator(view: View) {
        clickOperatorFlag = true;
        oldNumber = tvplace.text.toString();
        var btnSelect: Button = view as Button
        when (btnSelect.id) {
            btnmul.id -> {
                myOperator = "*"
            }
            btnadd.id -> {
                myOperator = "+"
            }
            btndiv.id -> {
                myOperator = "/"
            }
            btnsub.id -> {
                myOperator = "-"
            }
        }
    }

     fun clickEqual(view: View) {
        var latestNumber: String = tvplace.text.toString();
        var calResult = 0;
        when (myOperator) {
            "+" -> {
                calResult = oldNumber.toInt() + latestNumber.toInt()
            }
            "-" -> {
                calResult = oldNumber.toInt() - latestNumber.toInt()
            }
            "/" -> {
                calResult = oldNumber.toInt() / latestNumber.toInt()
            }
            "*" -> {
                calResult = oldNumber.toInt() * latestNumber.toInt()
            }
        }
        tvplace.setText(calResult.toString())
    }

    fun clearEvent(view: View) {
        tvplace.setText("0")
        clickOperatorFlag=true;
    }
}
