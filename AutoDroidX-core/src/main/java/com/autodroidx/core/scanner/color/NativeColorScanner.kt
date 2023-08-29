package com.autodroidx.core.scanner.color

import com.autodroidx.core.action.Action
import com.autodroidx.core.scanner.base.*

class NativeColorScanner: ColorScanner {
    override fun Action.getPointColor(point: Point): Color {
        TODO("Not yet implemented")
    }

    override fun Action.getPointColorList(pointList: List<Point>): List<Color> {
        TODO("Not yet implemented")
    }

    override fun Action.isCPointWork(cPoint: CPoint, diff: Double): Boolean {
        TODO("Not yet implemented")
    }

    override fun Action.isCPointListWork(cPointList: List<CPoint>, diff: Double, correctRate: Double): Boolean {
        TODO("Not yet implemented")
    }

    override fun Action.findColor(color: Color, diff: Double, area: Area): List<CPoint>? {
        TODO("Not yet implemented")
    }

    override fun Action.findColorList(colorList: List<Color>, diff: Double, area: Area): List<CPoint>? {
        TODO("Not yet implemented")
    }

    override fun Action.findColorMatrix(
        cPointVectorSet: CPointVectorSet,
        diff: Double,
        correctRate: Double,
        area: Area
    ): Point? {
        TODO("Not yet implemented")
    }

}