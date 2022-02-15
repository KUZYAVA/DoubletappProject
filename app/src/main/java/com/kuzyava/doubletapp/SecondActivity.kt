package com.kuzyava.doubletapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    private lateinit var tvCounter2: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "activity created")

        tvCounter2 = findViewById(R.id.counter2)
        btnBack = findViewById(R.id.back)

        val data = intent.getIntExtra(Constants.EXTRA_DATA, 0)
        val result = data * data
        tvCounter2.text = result.toString()

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(Constants.STATE_COUNTER2, tvCounter2.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        tvCounter2.text = savedInstanceState.getString(Constants.STATE_COUNTER2)
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