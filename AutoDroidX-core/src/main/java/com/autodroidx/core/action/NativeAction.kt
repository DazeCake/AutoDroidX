package com.autodroidx.core.action

import com.autodroidx.core.action.touch.slide.NativeSlide
import com.autodroidx.core.action.touch.slide.Slide
import com.autodroidx.core.action.touch.tap.NativeTap
import com.autodroidx.core.action.touch.tap.Tap
import com.autodroidx.core.scanner.color.ColorScanner
import com.autodroidx.core.scanner.color.NativeColorScanner
import com.autodroidx.core.scanner.screenshort.NativeScreenShorter
import com.autodroidx.core.scanner.screenshort.ScreenShorter

object NativeAction : Action,
    Slide by NativeSlide(),
    Tap by NativeTap(),
    ColorScanner by NativeColorScanner(),
    ScreenShorter by NativeScreenShorter()
