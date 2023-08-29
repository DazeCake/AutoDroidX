package com.autodroidx.core.scanner.base

/**
 * 点色向量集类，用于描述一个点色向量集，这并非广义上的向量，而是一个点色列表，
 * 实际上是对一个矩形区域的抽样，得到一个可以用于描述该区域大致特征的向量
 *
 * @property vector 点色向量
 */
class CPointVectorSet(private var vector: List<CPoint>) {

    /**
     * 源基准参考点，存储源坐标系中的原点，用于将相对坐标转换为源绝对坐标
     */
    private val baseOriginalPoint: Point

    /**
     * 抽象矩形区域的宽度
     */
    val width: Int
        get() = vector.maxBy { it.point.x }.point.x - vector.minBy { it.point.x }.point.x + 1

    /**
     * 抽象矩形区域的高度
     */
    val height: Int
        get() = vector.maxBy { it.point.y }.point.y - vector.minBy { it.point.y }.point.y + 1

    init {
        vector = vector.sortedWith(compareBy({ it.point.x }, { it.point.y }))
        baseOriginalPoint = vector[0].point
        vector = vector.map { CPoint(it.point.x - baseOriginalPoint.x, it.point.y - baseOriginalPoint.y, it.color) }
    }

    /**
     * 获取初始化时输入的源坐标
     *
     * @return 源坐标列表
     */
    fun getOriginalCPointList(): List<CPoint> {
        return getRelativeCPointList(baseOriginalPoint)
    }

    /**
     * 获取相对坐标系中的点色列表
     *
     * @param basePoint 基准参考点
     * @return 相对坐标系中的点色列表
     */
    fun getRelativeCPointList(basePoint: Point): List<CPoint> {
        return vector.map { CPoint(it.point.x + basePoint.x, it.point.y + basePoint.y, it.color) }
    }
}