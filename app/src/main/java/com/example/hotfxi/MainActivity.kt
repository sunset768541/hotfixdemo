package com.example.hotfxi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import dalvik.system.BaseDexClassLoader

class MainActivity : AppCompatActivity() {
    val permissions = arrayOf("android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview: TextView = findViewById(R.id.textview)
        findViewById<Button>(R.id.button).setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        textview.setText(BugCl.getS())
                    }
                }
        )
//        Reflhep.getPrivateStatic(classLoader as BaseDexClassLoader)
        requestPermissions(permissions,100)
    }
}