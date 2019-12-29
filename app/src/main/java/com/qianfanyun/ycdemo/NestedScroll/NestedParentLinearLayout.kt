package com.qianfanyun.ycdemo.NestedScroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingParent
import androidx.core.view.NestedScrollingParentHelper

/**
 * @date on 2019-12-19  10:43
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class NestedParentLinearLayout(context: Context, attr: AttributeSet) : LinearLayout(context, attr),
    NestedScrollingParent {

    var mParentHelper = NestedScrollingParentHelper(this)


    override fun onStartNestedScroll(child: View, target: View, axes: Int): Boolean {
        Log.d("ycc", "[parent] onStartNestedScroll")
        return true
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        Log.d("ycc", "[parent] onNestedPreScroll")
//        consumed[1] = dy
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int) {
        Log.d("ycc", "[parent] onNestedScrollAccepted")
        mParentHelper.onNestedScrollAccepted(child, target, axes)
    }

    override fun onStopNestedScroll(child: View) {
        Log.d("ycc", "[parent] onStopNestedScroll")
        mParentHelper.onStopNestedScroll(child)
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int
    ) {
        Log.d("ycc", "[parent] onNestedScroll")
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
    }


    override fun onNestedFling(
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        Log.d("ycc", "[parent] onNestedFling")
        return super.onNestedFling(target, velocityX, velocityY, consumed)
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        Log.d("ycc", "[parent] onNestedPreFling")
        return super.onNestedPreFling(target, velocityX, velocityY)
    }

    override fun getNestedScrollAxes(): Int {
        Log.d("ycc", "[parent] getNestedScrollAxes")
        return super.getNestedScrollAxes()
    }
}