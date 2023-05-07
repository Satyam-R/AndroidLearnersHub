package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView

class ProgressActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var progressBar2: ProgressBar
    private lateinit var progressText2: TextView
    private lateinit var progressBar3: ProgressBar
    private lateinit var progressText3: TextView
    private lateinit var progressBar4: ProgressBar
    private lateinit var progressText4: TextView
    private lateinit var progressBar5: ProgressBar
    private lateinit var progressText5: TextView
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

// Set the ids for the progress bars and progress texts
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.textView)
        progressBar2 = findViewById(R.id.progress_bar2)
        progressText2 = findViewById(R.id.textView2)
        progressBar3 = findViewById(R.id.progress_bar3)
        progressText3 = findViewById(R.id.textView3)
        progressBar4 = findViewById(R.id.progress_bar4)
        progressText4 = findViewById(R.id.textView4)
        progressBar5 = findViewById(R.id.progress_bar5)
        progressText5 = findViewById(R.id.textView5)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Set the limitations for the numeric
                // text under each progress bar
                if (i <= 100) {
                    progressText.text = (i-21).toString()
                    progressBar.progress = i-21
                    progressText2.text = (i-15).toString()
                    progressBar2.progress = i-15
                    progressText3.text = (i-24).toString()
                    progressBar3.progress = i-24
                    progressText4.text = (i-25).toString()
                    progressBar4.progress = i-25
                    progressText5.text = (i-20).toString()
                    progressBar5.progress = i-20
                    i++
                    handler.postDelayed(this, 20)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        }, 20)
    }
}