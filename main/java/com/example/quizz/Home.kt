package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class Home : AppCompatActivity() {

    lateinit var navig: com.google.android.material.navigation.NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*----------drawer-----------*/
        navig = findViewById(R.id.navView)
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navig.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    val intent = Intent(this, ReportActivity::class.java)
                    startActivity(intent)
                }
                R.id.item2 -> {
                    val intent = Intent(this, RateActivity::class.java)
                    startActivity(intent)
                }
                R.id.item3 -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                }
                R.id.item4 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }

/*------------------------------ Buttons Actions --------------------------------*/

        val view = findViewById<LinearLayout>(R.id.image1)
        val add = findViewById<LinearLayout>(R.id.image2)
        val performance = findViewById<LinearLayout>(R.id.image3)
        val feedback = findViewById<LinearLayout>(R.id.image4)
        view.setOnClickListener {
            val intent = Intent(this, Learn::class.java)
            startActivity(intent)
        }
        add.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }
        performance.setOnClickListener {
            val intent = Intent(this, ProgressActivity::class.java)
            startActivity(intent)
        }
        feedback.setOnClickListener {
            val intent = Intent(this, FeedbackActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*--------------------------------------- Action Bar -------------------------------------*/

        // calling this activity's function to
        // use ActionBar utility methods
        val actionBar = supportActionBar

        // providing title for the ActionBar
        actionBar!!.title = " Learners Hub"

        // providing subtitle for the ActionBar
        actionBar.subtitle = "Learn, Practice & Grow"

        // methods to display the icon in the ActionBar
        //actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
    }

    // methods to control the operations that will
    // happen when user clicks on the action buttons
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}