package br.com.lucao.ebac.exerciciomodulooito

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textTitle: TextView? = null
    private var editText: EditText? = null
    private var screen: ConstraintLayout? = null
    private var numClicks = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTitle = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        screen = findViewById(R.id.screen)

        val button = findViewById<Button>(R.id.button)
        button.text = "click aqui =)... "

        fun setTextChanged(){
            textTitle?.text = "Você digitou ${editText?.text}, e clicou no botão $numClicks vezes"
        }

        button.setOnClickListener {
            setTextChanged()
            numClicks++
            when{
                numClicks % 2 == 0 -> screen?.setBackgroundResource(R.drawable.campo)
                numClicks % 3 == 0 -> screen?.setBackgroundResource(R.drawable.cidade)
                else -> screen?.setBackgroundResource(R.drawable.praia)
            }
        }
    }
}