package com.kuzyava.doubletapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    private val TAG = "FirstActivity"
    private lateinit var tvCounter: TextView
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        title = getString(R.string.first)

        Log.d(TAG, "activity created")

        tvCounter = findViewById(R.id.counter)

        btnNext = findViewById(R.id.next)
        btnNext.setOnClickListener {
            val intent = Intent(
                this,
                SecondActivity::class.java
            ).apply {
                putExtra(Constants.EXTRA_DATA, tvCounter.text.toString().toInt())
            }
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(Constants.STATE_COUNTER, tvCounter.text.toString().toInt())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val data = savedInstanceState.getInt(Constants.STATE_COUNTER) + 1
        tvCounter.text = data.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "activity destroyed")
    }
}