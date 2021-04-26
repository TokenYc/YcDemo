package com.qianfanyun.ycdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
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
        val telephonyManager =
            getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.deviceId
    }

}
