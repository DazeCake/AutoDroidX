package com.autodroidx.core.action.touch.slide

import com.autodroidx.core.action.Action
import com.autodroidx.core.scanner.base.Point

/**
 *  滑动接口
 *
 */
interface Slide {

    /**
     * 单点滑动
     *
     * @param path    滑动路径，包含起始点和终止点的Pair对
     * @param duration  滑动时间
     * @param accelerate    滑动加速曲线
     */
    fun Action.slide(path: Pair<Point, Point>, duration: Long, accelerate: SlidesAccelerateCurve)

    /**
     * 多点滑动
     *
     * @param pathSet   滑动路径集合
     * @param duration  滑动时间
     * @param accelerate    滑动加速曲线
     */
    fun Action.slide(pathSet: List<Pair<Point, Point>>, duration: Long, accelerate: SlidesAccelerateCurve)

}