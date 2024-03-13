package com.dazecake.autodroidx.utils

import android.util.Log
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.OutputStream
import java.io.PrintStream


enum class Level {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR
}


internal class NullOutputStream : OutputStream() {
    override fun write(b: ByteArray) {
        // ignore
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        // ignore
    }

    override fun write(b: Int) {
        // ignore
    }
}


object Log {

    private var threshold: Level = Level.INFO

    private const val TAG = "AutoDroidX"
    private const val PREFIX = "[adx]: "

    private val CONSOLE_OUT = PrintStream(FileOutputStream(FileDescriptor.out))
    private val CONSOLE_ERR = PrintStream(FileOutputStream(FileDescriptor.err))

    private fun isEnabled(level: Level): Boolean {
        return level.ordinal >= threshold.ordinal
    }

    fun disableSystemStreams() {
        val nullStream = PrintStream(NullOutputStream())
        System.setOut(nullStream)
        System.setErr(nullStream)
    }

    fun v(message: String) {
        if (isEnabled(Level.VERBOSE)) {
            Log.v(TAG, message)
            CONSOLE_OUT.print(PREFIX + "VERBOSE: " + message + '\n')
        }
    }

    fun d(message: String) {
        if (isEnabled(Level.DEBUG)) {
            Log.d(TAG, message)
            CONSOLE_OUT.print(PREFIX + "DEBUG: " + message + '\n')
        }
    }

    fun i(message: String) {
        if (isEnabled(Level.INFO)) {
            Log.i(TAG, message)
            CONSOLE_OUT.print(PREFIX + "INFO: " + message + '\n')
        }
    }

    fun w(message: String) {
        if (isEnabled(Level.WARN)) {
            Log.w(TAG, message)
            CONSOLE_ERR.print(PREFIX + "WARN: " + message + '\n')
        }
    }

    fun e(message: String) {
        if (isEnabled(Level.ERROR)) {
            Log.e(TAG, message)
            CONSOLE_ERR.print(PREFIX + "ERROR: " + message + '\n')
        }
    }

    fun e(message: String, e: Throwable) {
        if (isEnabled(Level.ERROR)) {
            Log.e(TAG, message, e)
            CONSOLE_ERR.print(PREFIX + "ERROR: " + message + '\n')
            e.printStackTrace(CONSOLE_ERR)
        }
    }

    fun setLevel(level: Level) {
        Log.i(TAG, "Setting log level to $level")
        threshold = level
    }



}