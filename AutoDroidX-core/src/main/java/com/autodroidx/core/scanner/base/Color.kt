package com.autodroidx.core.scanner.base

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 颜色类，用于描述一个颜色，内涵一个成员变量hexColor，用于表示颜色的16进制表示
 *
 * @property hexColor 16进制表示的颜色，要求不带前缀0x和#，不区分大小写例如：ff0000
 */
class Color(private val hexColor: String) {
    init {
        require(hexColor.matches("[0-9a-fA-F]{6}".toRegex())) {
            "Invalid hex code format. Hex code should be a 6-digit string consisting of 0-9, a-f, or A-F characters."
        }
    }

    /**
     * 获取16进制表示的颜色，不带前缀0x和#
     *
     * @return 16进制颜色
     */
    fun getHexColor(): String {
        return hexColor
    }

    /**
     * 获取红色通道值
     *
     * @return 红色通道值
     */
    fun getRed(): Int {
        return hexColor.substring(0, 2).toInt(16)
    }

    /**
     * 获取绿色通道值
     *
     * @return 绿色通道值
     */
    fun getGreen(): Int {
        return hexColor.substring(2, 4).toInt(16)
    }

    /**
     * 获取蓝色通道值
     *
     * @return 蓝色通道值
     */
    fun getBlue(): Int {
        return hexColor.substring(4, 6).toInt(16)
    }

    /**
     * 计算与另一个颜色的相似度
     *
     * @param otherColor    另一个颜色
     * @return              相似度，介于0-1之间
     */
    fun calculateSimilarity(otherColor: Color): Double {
        val redDiff = getRed() - otherColor.getRed()
        val greenDiff = getGreen() - otherColor.getGreen()
        val blueDiff = getBlue() - otherColor.getBlue()

        val distance = sqrt(redDiff.toDouble().pow(2) + greenDiff.toDouble().pow(2) + blueDiff.toDouble().pow(2))
        val maxDistance = sqrt((255 * 255 * 3).toDouble()) // 最大距离为白色和黑色之间的距离

        return 1 - (distance / maxDistance)
    }

    /**
     * 判断两个颜色是否严格相等
     *
     * @param otherColor   另一个颜色
     * @return             是否相等
     */
    fun isEquals(otherColor: Color): Boolean {
        return hexColor.lowercase(Locale.getDefault()) == otherColor.getHexColor().lowercase(Locale.getDefault())
    }

    /**
     * 判断两个颜色是否相似
     *
     * @param otherColor    另一个颜色
     * @param diff          误差值，介于0-1之间，越小越严格
     * @return              是否相似
     */
    fun isLike(otherColor: Color, diff: Double = 0.01): Boolean {
        return calculateSimilarity(otherColor) >= 1 - diff
    }
}