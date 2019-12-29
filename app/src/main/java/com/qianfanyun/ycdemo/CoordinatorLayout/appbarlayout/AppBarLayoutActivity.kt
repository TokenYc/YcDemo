package com.qianfanyun.ycdemo.CoordinatorLayout.appbarlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qianfanyun.ycdemo.R

class AppBarLayoutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)
    }
}


//layout_scrollFlags
//1.enterAlways:滑动时不管是否滑动到顶部，都进行同步滑动。
//2.exitUntilCollapsed 为AppBarLayout包裹在内的View设置，可以设置minHeight，使得滑动时能保留minHeight的部分，始终悬浮在顶部。
//3.enterAlways|enterAlwaysCollapsed 与2不同的是，滑动时，minHeight部分也会隐藏，滑到顶部时，会显示全部。