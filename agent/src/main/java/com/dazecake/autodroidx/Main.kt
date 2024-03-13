package com.dazecake.autodroidx

import android.os.Build
import com.dazecake.autodroidx.utils.Log
import com.dazecake.autodroidx.utils.Options
import kotlin.system.exitProcess

object Main {
    /**
     * Main entry point for the agent.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        var status = 0
        try {
            init(args)
        } catch (e: Exception) {
            e.message?.let { Log.e(it, e) }
            status = 1
        } finally {
            exitProcess(status)
        }
    }

    private fun init(args: Array<String>) {
        Thread.setDefaultUncaughtExceptionHandler { t: Thread, e: Throwable? ->
            e?.let {
                Log.e(
                    "Exception on thread $t",
                    it
                )
            }
        }

        val options = Options().paras(args)

        Log.disableSystemStreams()
        Log.setLevel(options.logLevel)

        Log.i("Device: [" + Build.MANUFACTURER + "] " + Build.BRAND + " " + Build.MODEL + " (Android " + Build.VERSION.RELEASE + ")")
    }
}

