package com.qianfanyun.ycdemo.CoordinatorLayout.nested

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat.dispatchNestedPreFling
import androidx.core.view.ViewCompat.dispatchNestedFling
import androidx.core.view.ViewCompat.isNestedScrollingEnabled
import androidx.core.view.ViewCompat.setNestedScrollingEnabled
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.NestedScrollingChild
import androidx.core.view.NestedScrollingChild3
import androidx.core.view.get
import com.qianfanyun.ycdemo.R
import kotlin.math.absoluteValue


/**
 * @date on 2019-12-25  16:50
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class NestedCoordinatorLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes
    @SuppressLint("PrivateResource")
    defStyleAttr: Int = R.attr.coordinatorLayoutStyle
) : CoordinatorLayout(context, attrs, defStyleAttr), NestedScrollingChild3 {

    private val helper = NestedScrollingChildHelper(this)

    init {
        isNestedScrollingEnabled = true
    }

    override fun isNestedScrollingEnabled(): Boolean = helper.isNestedScrollingEnabled

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        helper.isNestedScrollingEnabled = enabled
    }

    override fun hasNestedScrollingParent(type: Int): Boolean =
        helper.hasNestedScrollingParent(type)

    override fun hasNestedScrollingParent(): Boolean = helper.hasNestedScrollingParent()

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        val superResult = super.onStartNestedScroll(child, target, axes, type)
        return startNestedScroll(axes, type) || superResult
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int): Boolean {
        val superResult = super.onStartNestedScroll(child, target, axes)
        return startNestedScroll(axes) || superResult
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        val parentView = parent as ViewGroup
        // TODO: 2020/12/15 这里要改成全局搜索parent的appBarLayout或者直接设置，child也要修改设置方式
        val parentAppBarLayout = parentView.getChildAt(0)
        val childAppBarLayout = getChildAt(0)
        if (dy > 0) {
            if (parentAppBarLayout.y.absoluteValue < parentAppBarLayout.height) {
                dispatchNestedPreScroll(dx, dy, consumed, null, type)
            } else {
                super.onNestedPreScroll(target, dx, dy, consumed, type)
            }
        } else {
            if (childAppBarLayout.y.absoluteValue < childAppBarLayout.height) {
                super.onNestedPreScroll(target, dx, dy, consumed, type)
            } else if (parentAppBarLayout.y.absoluteValue < parentAppBarLayout.height) {
                dispatchNestedPreScroll(dx, dy, consumed, null, type)
            } else {
                super.onNestedPreScroll(target, dx, dy, consumed, type)
            }
        }
    }



    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        val superConsumed = intArrayOf(0, 0)
        super.onNestedPreScroll(target, dx, dy, superConsumed)
        val thisConsumed = intArrayOf(0, 0)
        dispatchNestedPreScroll(dx, dy, consumed, null)
        consumed[0] = superConsumed[0] + thisConsumed[0]
        consumed[1] = superConsumed[1] + thisConsumed[1]
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        // TODO: 2020/12/15 这里要改成全局搜索parent的appBarLayout或者直接设置，child也要修改设置方式
        val childAppBarLayout = getChildAt(0)
        if (childAppBarLayout.y.absoluteValue ==0f) {
            dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, null, type)
        }
        super.onNestedScroll(
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
    }

    override fun onNestedScroll(
        target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int,
        dyUnconsumed: Int, type: Int
    ) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, null, type)
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int
    ) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, null)
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        super.onStopNestedScroll(target, type)
        stopNestedScroll(type)
    }

    override fun onStopNestedScroll(target: View) {
        super.onStopNestedScroll(target)
        stopNestedScroll()
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        val superResult = super.onNestedPreFling(target, velocityX, velocityY)
        return dispatchNestedPreFling(velocityX, velocityY) || superResult
    }

    override fun onNestedFling(
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        val superResult = super.onNestedFling(target, velocityX, velocityY, consumed)
        return dispatchNestedFling(velocityX, velocityY, consumed) || superResult
    }

    override fun startNestedScroll(axes: Int, type: Int): Boolean =
        helper.startNestedScroll(axes, type)

    override fun startNestedScroll(axes: Int): Boolean = helper.startNestedScroll(axes)

    override fun stopNestedScroll(type: Int) {
        helper.stopNestedScroll(type)
    }

    override fun stopNestedScroll() {
        helper.stopNestedScroll()
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        offsetInWindow: IntArray?,
        type: Int,
        consumed: IntArray
    ) {
        helper.dispatchNestedScroll(
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            offsetInWindow,
            type,
            consumed
        )
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int,
        offsetInWindow: IntArray?, type: Int
    ): Boolean = helper.dispatchNestedScroll(
        dxConsumed,
        dyConsumed,
        dxUnconsumed,
        dyUnconsumed,
        offsetInWindow,
        type
    )

    override fun dispatchNestedScroll(
        dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int,
        dyUnconsumed: Int, offsetInWindow: IntArray?
    ): Boolean = helper.dispatchNestedScroll(
        dxConsumed,
        dyConsumed,
        dxUnconsumed,
        dyUnconsumed,
        offsetInWindow
    )

    override fun dispatchNestedPreScroll(
        dx: Int, dy: Int, consumed: IntArray?,
        offsetInWindow: IntArray?, type: Int
    ): Boolean = helper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)

    override fun dispatchNestedPreScroll(
        dx: Int,
        dy: Int,
        consumed: IntArray?,
        offsetInWindow: IntArray?
    ): Boolean =
        helper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean =
        helper.dispatchNestedPreFling(velocityX, velocityY)

    override fun dispatchNestedFling(
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean =
        helper.dispatchNestedFling(velocityX, velocityY, consumed)
}