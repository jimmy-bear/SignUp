package com.example.signup

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var level=0
        getSharedPreferences("personal", Context.MODE_PRIVATE)
            .run {
                val array=resources.getStringArray(R.array.gender)
                txNickMain.text=getString("nickName","unKnown")
                txAgeMain.text=getString("age","18")
                txGenderMain.text=array[getInt("gender",0)]
                level=getInt("level",0)
            }
        when(level) {
            0-> {
                startActivity(Intent(this, NickNameActivity::class.java))
                finish()
            }
            1-> {
                startActivity(Intent(this, AgeActivity::class.java))
                finish()
            }
            2-> {
                startActivity(Intent(this, GenderActivity::class.java))
                finish()
            }
            else->{}
        }
        radioTest.setOnCheckedChangeListener { radioGroup, i ->
            val levelChenge=when(radioGroup.checkedRadioButtonId){
                R.id.radioButton->0
                R.id.radioButton2->1
                else->2
            }
            getSharedPreferences("personal", Context.MODE_PRIVATE)
                .edit()
                .putInt("level",levelChenge)
                .apply()
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

