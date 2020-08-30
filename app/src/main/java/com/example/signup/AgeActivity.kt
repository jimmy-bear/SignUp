package com.example.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_age.*

class AgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        btnNextAge.setOnClickListener {
            val age=edAge.text.toString()
            if(age.toInt() in 1..130) {
                getSharedPreferences("personal", Context.MODE_PRIVATE)
                    .edit()
                    .putString("age", edAge.text.toString())
                    .putInt("level", 2)
                    .apply()
                startActivity(Intent(this, GenderActivity::class.java))
                finish()
            }else{
                AlertDialog.Builder(this)
                    .setMessage("Please Enter Current Age")
                    .setPositiveButton("OK",null)
                    .show()
            }
        }
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you want to leave?")
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }.setNeutralButton("No",null)
            .show()
    }
}