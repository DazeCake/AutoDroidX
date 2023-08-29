package com.autodroidx.core.scanner.base

/**
 * 色点类，用于描述一个带颜色的点
 *
 * @property point  点
 * @property color  颜色
 */
class CPoint(val point: Point, val color: Color) {
    constructor(x: Int, y: Int, color: Color) : this(Point(x, y), color)

    constructor(x: Int, y: Int, hexColor: String) : this(Point(x, y), Color(hexColor))
}