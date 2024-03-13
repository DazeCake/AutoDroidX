package com.dazecake.autodroidx.utils

data class Options(
    var logLevel: Level = Level.DEBUG,
) {
    fun paras(args: Array<String>): Options {
        val options = Options()
        for (i in args.indices) {
            if (args[i] == "-v") {
                options.logLevel = Level.VERBOSE
            }
        }
        return options
    }
}