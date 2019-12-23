package com.qianfanyun.ycdemo

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import com.qianfanyun.lint_test_lib.DeviceUtils
import com.qianfanyun.ycdemo.CoordinatorLayout.CoordinatorLayoutActivity
import com.qianfanyun.ycdemo.NestedScroll.NestedScrollActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coordinatorLayout.setOnClickListener {
            startActivity(Intent(this, CoordinatorLayoutActivity::class.java))
        }
        nestedScroll.setOnClickListener {
            startActivity(Intent(this, NestedScrollActivity::class.java))
        }
    }

}
