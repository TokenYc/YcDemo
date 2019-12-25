package com.qianfanyun.ycdemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * @date on 2019-12-25  10:04
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class MyApplication : Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}