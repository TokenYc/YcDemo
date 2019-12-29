package com.qianfanyun.ycdemo.NestedScroll

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingChild
import androidx.core.view.NestedScrollingChildHelper

/**
 * @date on 2019-12-25  15:15
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class NestedChildLinearLayout(context: Context, attr: AttributeSet) : LinearLayout(context, attr),
    NestedScrollingChild {

    var mChildHelper = NestedScrollingChildHelper(this)

    override fun isNestedScrollingEnabled(): Boolean {
        Log.d("ycc", "[child] isNestedScrollingEnabled")
        return true
    }

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        Log.d("ycc", "[child] setNestedScrollingEnabled")
        mChildHelper.isNestedScrollingEnabled = enabled
    }


    override fun startNestedScroll(axes: Int): Boolean {
        Log.d("ycc", "[child] startNestedScroll")
        return mChildHelper.startNestedScroll(axes)
    }

    override fun stopNestedScroll() {
        Log.d("ycc", "[child] stopNestedScroll")
        mChildHelper.stopNestedScroll()
    }

    override fun hasNestedScrollingParent(): Boolean {
        Log.d("ycc", "[child] hasNestedScrollingParent")
        return mChildHelper.hasNestedScrollingParent()
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        offsetInWindow: IntArray?
    ): Boolean {
        Log.d("ycc", "[child] dispatchNestedScroll")
        return mChildHelper.dispatchNestedScroll(
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            offsetInWindow
        )
    }

    override fun dispatchNestedPreScroll(
        dx: Int,
        dy: Int,
        consumed: IntArray?,
        offsetInWindow: IntArray?
    ): Boolean {
        Log.d("ycc", "[child] dispatchNestedPreScroll")
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)
    }

    override fun dispatchNestedFling(
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        Log.d("ycc", "[child] dispatchNestedFling")
        return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed)
    }

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean {
        Log.d("ycc", "[child] dispatchNestedPreFling")
        return mChildHelper.dispatchNestedPreFling(velocityX, velocityY)
    }


}