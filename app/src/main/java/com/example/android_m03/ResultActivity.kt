package com.example.android_m03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        returnBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("message", "消息消息消息消息消息消息消息")
            setResult(9999, intent)
            finish()
        }
    }
}
