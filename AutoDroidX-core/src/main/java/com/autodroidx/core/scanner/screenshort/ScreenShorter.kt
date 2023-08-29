package com.autodroidx.core.scanner.screenshort

import com.android.ddmlib.RawImage

/**
 * 截图捕获器接口
 *
 */
interface ScreenShorter {

    /**
     * 获取截图
     *
     * @return RawImage 原始截图数据
     */
    fun getScreenShort(): RawImage?

    /**
     * 保存截图到指定路径
     *
     * @param path 保存路径
     */
    fun saveScreenShort(path: String)

}