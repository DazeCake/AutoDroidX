package com.dazecake.autodroidx.loader

import android.annotation.SuppressLint
import android.os.Build
import com.dazecake.autodroidx.utils.Log

class JNI {

    external fun stringFromJNI(): String

    @SuppressLint("UnsafeDynamicallyLoadedCode")
    companion object {
        init {
            // dirty hack
            // app_process is not able to load libraries from the apk because it can't set the LD_LIBRARY_PATH
            // try to get lib absolute path from CLASSPATH and load it absolute
            // and useLegacyPackaging should be set to false in the build.gradle.kts
            val libPath = (System.getenv("CLASSPATH")?.plus("!/lib/")
                ?: "/data/local/tmp/autodroidx-agent.jar!/lib/".also {
                    Log.i("CLASSPATH not found, using default path")
                }) + Build.SUPPORTED_ABIS[0] +
                    "/libScriptLoader.so"

            try {
                System.load(libPath)
            } catch (e: Throwable) {
                Log.e("Failed to load library:\n\t" + e.message)
            }
        }
    }
}