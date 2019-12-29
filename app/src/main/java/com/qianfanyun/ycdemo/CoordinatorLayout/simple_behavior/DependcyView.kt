package com.qianfanyun.ycdemo.CoordinatorLayout.simple_behavior

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * @date on 2019-12-29  14:05
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class DependcyView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    var downX = 0.0f
    var downY = 0.0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.rawX
                    downY = event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    x += (event.rawX - downX)
                    y += (event.rawY - downY)
                    downX = event.rawX
                    downY = event.rawY
                }
            }
        }
        return true
    }
}