package com.autodroidx.core.scanner.base

import android.graphics.Point
import kotlin.math.max
import kotlin.math.min

/**
 * 区域类，用于描述一个矩形区域，内涵一个成员变量isAll，用于表示是否为全屏区域，
 * 若isAll为true，则表示为全屏区域，此时startPoint和endPoint无效。
 *
 * @property startPoint 起始点
 * @property endPoint   终止点
 */
class Area(var startPoint: Point, var endPoint: Point) {

    /**
     * 是否为全屏区域
     */
    var isAll: Boolean = false

    /**
     * 初始化输入的坐标，使得startPoint为左上角，endPoint为右下角
     */
    init {
        startPoint = Point(min(startPoint.x, endPoint.x), min(startPoint.y, endPoint.y))
        endPoint = Point(max(startPoint.x, endPoint.x), max(startPoint.y, endPoint.y))
    }

    constructor(x1: Int, y1: Int, x2: Int, y2: Int) : this(Point(x1, y1), Point(x2, y2))

    constructor(isAll: Boolean) : this(Point(0, 0), Point(0, 0)) {
        this.isAll = isAll
    }

}