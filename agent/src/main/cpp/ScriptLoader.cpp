#include <jni.h>
#include <string>

//
// Created by DazeCake on 2024/3/21.
//

extern "C"
JNIEXPORT jstring JNICALL
Java_com_dazecake_autodroidx_loader_JNI_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}