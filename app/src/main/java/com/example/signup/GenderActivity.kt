package com.example.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_gender.*

class GenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)
        btnNextGender.setOnClickListener {
            val gender=when(radioGender.checkedRadioButtonId){
                R.id.radioMan->0
                else->1
            }
            getSharedPreferences("personal", Context.MODE_PRIVATE)
                .edit()
                .putInt("gender",gender)
                .putInt("level",3)
                .apply()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
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