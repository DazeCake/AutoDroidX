#include <jni.h>
#include <string>
#include "android/log.h"
#include "LogProxy.h"
#include "jenny_fusion_proxies.h"

//
// Created by DazeCake on 2024/3/21.
//

extern "C"
JNIEXPORT jstring JNICALL
Java_com_dazecake_autodroidx_loader_JNI_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    jenny::LocalRef<jstring> str(env->NewStringUTF("Hello from C call Kt log"));
    jennySampleErrorLog(env, "Native error log from C++");
    LogProxy::i(str);
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env),
                   JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    ::jenny::Env::attachJvm(vm);

    auto ok = jenny::initAllProxies(env);

    assert(ok);

    return JNI_VERSION_1_6;
}

void jennySampleErrorLog(JNIEnv *env, const char *error) {
    __android_log_write(ANDROID_LOG_ERROR, "AutoDroidX-C", error);
    env->ExceptionDescribe();
}