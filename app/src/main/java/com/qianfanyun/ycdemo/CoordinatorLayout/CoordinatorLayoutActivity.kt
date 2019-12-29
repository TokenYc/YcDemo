package com.qianfanyun.ycdemo.CoordinatorLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qianfanyun.ycdemo.CoordinatorLayout.nested.CoordinatorNestActivity
import com.qianfanyun.ycdemo.CoordinatorLayout.simple_behavior.SimpleBehaviorActivity
import com.qianfanyun.ycdemo.R
import kotlinx.android.synthetic.main.activity_coordinator_layout2.*

class CoordinatorLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout2)
        tv_webview.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CoordinatorLayoutActivity::class.java
                )
            )
        }
        tv_nest.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CoordinatorNestActivity::class.java
                )
            )
        }
        tv_simple_behavior.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SimpleBehaviorActivity::class.java
                )
            )
        }
    }
}
