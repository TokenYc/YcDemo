package com.qianfanyun.ycdemo.CoordinatorLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qianfanyun.ycdemo.CoordinatorLayout.appbarlayout.AppBarLayoutActivity
import com.qianfanyun.ycdemo.CoordinatorLayout.nested.CoordinatorNestActivity
import com.qianfanyun.ycdemo.CoordinatorLayout.simple_behavior.SimpleBehaviorActivity
import com.qianfanyun.ycdemo.CoordinatorLayout.webview.CoordinatorLayoutWebviewActivity
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
                    CoordinatorLayoutWebviewActivity::class.java
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
        tv_appbarlayout.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AppBarLayoutActivity::class.java
                )
            )
        }
    }
}
