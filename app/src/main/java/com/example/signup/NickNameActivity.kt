package com.example.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_nick_name.*

class NickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)
        btnNextNick.setOnClickListener {
            getSharedPreferences("personal", Context.MODE_PRIVATE)
                .edit()
                .putString("nickName",edNickName.text.toString())
                .putInt("level",1)
                .apply()
            startActivity(Intent(this,AgeActivity::class.java))
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