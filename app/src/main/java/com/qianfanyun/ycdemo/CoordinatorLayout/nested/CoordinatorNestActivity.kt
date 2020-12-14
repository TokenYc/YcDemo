package com.qianfanyun.ycdemo.CoordinatorLayout.nested

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.qianfanyun.ycdemo.R
import kotlinx.android.synthetic.main.activity_coordinator_nest.*

class CoordinatorNestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_nest)
        imv_inner.setOnClickListener {
            Toast.makeText(this,"inner image click",Toast.LENGTH_SHORT).show()
        }
    }
}
