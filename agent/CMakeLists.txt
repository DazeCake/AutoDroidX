cmake_minimum_required(VERSION 3.22.1)

add_library(
        ScriptLoader
        SHARED
        src/main/cpp/ScriptLoader.cpp
)

find_library(
        log-lib
        log
)

target_link_libraries(
        ScriptLoader
        ${log-lib}
)