cmake_minimum_required(VERSION 3.22.1)

include_directories(
        gen
)

add_library(
        ScriptLoader
        SHARED
        ScriptLoader.cpp
)

find_library(
        log-lib
        log
)

target_link_libraries(
        ScriptLoader
        ${log-lib}
)