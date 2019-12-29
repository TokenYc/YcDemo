package com.qianfanyun.ycdemo.CoordinatorLayout.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.qianfanyun.ycdemo.R
import kotlinx.android.synthetic.main.activity_coordinator_layout.*

class CoordinatorLayoutWebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        webview.webViewClient = WebViewClient()
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("https://qianfan3.qianfanapi.com/fenlei/sort/get-sort-list")
        //https://qianfan3.qianfanapi.com/fenlei/sort/get-sort-list
    }
}
