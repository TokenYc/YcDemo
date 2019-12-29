package com.qianfanyun.ycdemo.CoordinatorLayout.simple_behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * @date on 2019-12-29  14:36
 * @author ArcherYc
 * @mail  247067345@qq.com
 */
class SimpleBehavior(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<Button>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: Button,
        dependency: View
    ): Boolean {
        return dependency is DependcyView
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: Button,
        dependency: View
    ): Boolean {
        child.x = dependency.x+dependency.width+100
        child.y = dependency.y +dependency.height+100
        return true
    }

}