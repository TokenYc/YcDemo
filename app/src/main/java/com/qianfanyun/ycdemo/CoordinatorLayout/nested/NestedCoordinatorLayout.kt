package com.qianfanyun.ycdemo.CoordinatorLayout.nested

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * @date on 2019-12-25  16:50
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class NestedCoordinatorLayout(context: Context, attrs: AttributeSet?) :
    CoordinatorLayout(context, attrs) {
    var lastScrollY = 0
//    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
//        consumed[1]=dy
//        super.onNestedPreScroll(target, dx, dy, consumed)
//    }
//
//    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
//        consumed[1]=dy
//        super.onNestedPreScroll(target, dx, dy, consumed, type)
//    }


    override fun onStartNestedScroll(child: View, target: View, nestedScrollAxes: Int): Boolean {
        var consume = true
        super.onStartNestedScroll(child, target, nestedScrollAxes)
        if (child.y > 0) {
            consume = true
        } else if (child.y == 0.0f) {
            if (lastScrollY == 0) {
                consume = false
            } else {
                consume = true
            }
        } else {
            consume = false
        }
        lastScrollY = getChildAt(1).scrollY
        Log.d(
            "ycc",
            "1 Y-->${child.y}  childHeight-->${child.height} consmue-->${consume}"
        )
        return consume

    }

    /**
     * consume 为true 表示自己消耗嵌套滑动
     * consume 为false 表示让更底层的CoordinatorLayout来处理嵌套滑动
     */
    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        var consume = true
        super.onStartNestedScroll(child, target, axes, type)
//        if (child.y > 0) {
//            consume = true
//        } else if (child.y == 0.0f) {
//            if (lastScrollY == 0) {
//                consume = false
//            } else {
//                consume = true
//            }
//        } else {
//            consume = false
//        }
//        if (getChildAt(0).y == 0.0f && y == 0.0f) {
//            consume = true
//        } else {
//            consume = false
//        }
        if (y > 0) {
            consume = false
        } else {
            if (child.scrollY == 0) {
                consume = true
            }
        }
        lastScrollY = getChildAt(1).scrollY
        Log.d(
            "ycc",
            "2 child Y-->${child.y}  chid scrollY-->${getChildAt(1).scrollY} y-->${y} consmue-->${consume}"
        )
        return consume
    }


}