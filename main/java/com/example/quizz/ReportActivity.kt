package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val btn = findViewById<Button>(R.id.btnSubmit)
        btn.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.custom)
            val inflater = layoutInflater

            val layout: View = inflater.inflate(R.layout.custom_toast_report, vg)

            val tv = layout.findViewById<TextView>(R.id.txt)
            tv.text = "Thank you for reporting!"

            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.BOTTOM, 0, 50)
            toast.setView(layout)
            toast.duration = Toast.LENGTH_LONG
            toast.show()

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }

        val languages = resources.getStringArray(R.array.Interfaces)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@ReportActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(applicationContext, "Please select an option", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}