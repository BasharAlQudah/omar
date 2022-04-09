package com.example.bashar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val years = resources.getStringArray(R.array.spYears)
        val name:EditText = findViewById(R.id.edName)
        val id:EditText = findViewById(R.id.edStudentId)
        val spinner:Spinner = findViewById(R.id.spStdYear)
        val exit:Button = findViewById(R.id.btnExit)
        val information:TextView = findViewById(R.id.txtInfo)
        val currentYear:TextView = findViewById(R.id.txtYear)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, years)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    val year:String = parent?.getItemAtPosition(position).toString()
                    if (position > 0 ){
                        currentYear.setText("You are in your " + year)
                        information.setText("Your ID is " + id.toString().toInt() + "\n" + "Your name is " + name.text.toString() + "\n")
                    }

                }


                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        exit.setOnClickListener{view ->
            currentYear.setText("")
            information.setText("")
        }

    }
}