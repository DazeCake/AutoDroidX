package com.autodroidx.core.action.touch.tap

import com.autodroidx.core.action.Action
import com.autodroidx.core.scanner.base.Point

/**
 * 点击接口
 *
 */
interface Tap {

    /**
     * 点击
     *
     * @param p 点
     */
    fun Action.tap(p: Point)

    /**
     * 点击
     *
     * @param p 点
     * @param duration 点击持续时间
     */
    fun Action.tap(p: Point, duration: Long)

    /**
     * 点击
     *
     * @param p 点
     * @param duration 点击持续时间
     * @param pressure 点击压力
     */
    fun Action.tap(p: Point, duration: Long, pressure: Float)

}