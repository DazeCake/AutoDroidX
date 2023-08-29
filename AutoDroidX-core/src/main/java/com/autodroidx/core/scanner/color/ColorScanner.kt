package com.autodroidx.core.scanner.color

import com.autodroidx.core.action.Action
import com.autodroidx.core.scanner.base.*

interface ColorScanner {
    /**
     * 单点取色
     *
     * @param point 坐标点
     * @return      颜色
     */
    fun Action.getPointColor(point: Point): Color

    /**
     * 多点取色
     *
     * @param pointList 坐标点列表
     * @return          颜色列表
     */
    fun Action.getPointColorList(pointList: List<Point>): List<Color>

    /**
     * 单点比色 检查点的颜色是否和预期颜色一致或相似
     *
     * @param cPoint    点色
     * @param diff      颜色误差值
     * @return          是否符合要求
     */
    fun Action.isCPointWork(cPoint: CPoint, diff: Double = 0.0): Boolean

    /**
     * 多点比色 检查点列表的颜色是否和预期颜色一致或相似，若相似的点数量大于等于正确率correctRate，则返回true
     *
     * @param cPointList    点色列表
     * @param diff          颜色误差值
     * @param correctRate   要求的正确率
     * @return              是否符合要求
     */
    fun Action.isCPointListWork(cPointList: List<CPoint>, diff: Double = 0.0, correctRate: Double = 1.0): Boolean

    /**
     * 区域查找颜色
     *
     * @param color 颜色
     * @param diff  颜色误差值
     * @param area  查找区域
     * @return
     */
    fun Action.findColor(color: Color, diff: Double = 0.0, area: Area = Area(true)): List<CPoint>?

    /**
     * 区域查找多个颜色
     *
     * @param colorList 颜色列表
     * @param diff      颜色误差值
     * @param area      查找区域
     * @return          找到的点色列表
     */
    fun Action.findColorList(colorList: List<Color>, diff: Double = 0.0, area: Area = Area(true)): List<CPoint>?


    /**
     * 区域查找色点向量集
     *
     * @param cPointVectorSet  颜色矩阵
     * @param diff          颜色误差值
     * @param correctRate   要求的矩阵正确率
     * @param area          查找区域
     * @return 找到的矩阵基坐标
     */
    fun Action.findColorMatrix(
        cPointVectorSet: CPointVectorSet,
        diff: Double = 0.0,
        correctRate: Double = 1.0,
        area: Area = Area(true)
    ): Point?
}