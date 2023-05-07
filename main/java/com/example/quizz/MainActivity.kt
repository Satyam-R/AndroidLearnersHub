package com.example.quizz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    val Email="emailKey"
    val Pass="passKey"
    val myfile = "myprefile"
    @SuppressLint("MissingInflatedId")

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // To hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)

        /*--------------------------------- Shared Preferences ------------------------------*/

        sharedPreferences=getSharedPreferences(myfile, Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        emailEditText.setText(sharedPreferences.getString(Email,""))
        passwordEditText.setText(sharedPreferences.getString(Pass,""))

        var btn = findViewById<Button>(R.id.btn_start)
        btn.setOnClickListener{
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate email and password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(email)) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            } else {
                // Check if email and password match a user account
                if (email == "admin@gmail.com" && password == "password") {
                    //Saving the id pass
                    val e=emailEditText.text.toString()
                    val p=passwordEditText.text.toString()
                    editor.putString(Email,e)
                    editor.putString(Pass,p)
                    editor.apply()

                    // Login successful, start HomeActivity
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                } else {
                    // Login failed, show error message
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}