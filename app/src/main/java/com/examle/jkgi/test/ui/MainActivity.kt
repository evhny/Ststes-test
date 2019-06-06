package com.examle.jkgi.test.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.examle.jkgi.test.R
import com.examle.jkgi.test.ui.states.StatesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.rootView, StatesListFragment.newInstance())
                .commit()
    }
}
