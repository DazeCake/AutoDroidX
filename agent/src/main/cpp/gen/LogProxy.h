/**
 * File generated by Jenny -- https://github.com/LanderlYoung/Jenny
 *
 * DO NOT EDIT THIS FILE.
 *
 * For bug report, please refer to github issue tracker https://github.com/LanderlYoung/Jenny/issues.
 */
#pragma once

#include <jni.h>
#include <assert.h>                        
#include <atomic>
#include <mutex>

#include "jnihelper.h"


class LogProxy {

public:
    static constexpr auto FULL_CLASS_NAME = "com/dazecake/autodroidx/utils/Log";

    static constexpr auto TAG = u8"AutoDroidX";
    static constexpr auto PREFIX = u8"[adx]: ";


public:

    static bool initClazz(JNIEnv* env);
    
    static void releaseClazz(JNIEnv* env);

    static void assertInited(JNIEnv* env) {
        auto initClazzSuccess = initClazz(env);
        assert(initClazzSuccess);
    }
    
    // construct: private Log()
    static jobject newInstance(JNIEnv* env) {
        assertInited(env);
        return env->NewObject(getClassInitState().sClazz, getClassInitState().sConstruct_0);
    } 
    

    // method: private static final boolean isEnabled(com.dazecake.autodroidx.utils.Level level)
    static jboolean isEnabled(JNIEnv* env, jobject level) {
        assertInited(env);
        return env->CallStaticBooleanMethod(getClassInitState().sClazz, getClassInitState().sMethod_isEnabled_0, level);
    }

    // method: public static final void disableSystemStreams()
    static void disableSystemStreams(JNIEnv* env) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_disableSystemStreams_0);
    }

    // method: public static final void v(java.lang.String message)
    static void v(JNIEnv* env, jstring message) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_v_0, message);
    }

    // method: public static final void d(java.lang.String message)
    static void d(JNIEnv* env, jstring message) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_d_0, message);
    }

    // method: public static final void i(java.lang.String message)
    static void i(JNIEnv* env, jstring message) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_i_0, message);
    }

    // method: public static final void w(java.lang.String message)
    static void w(JNIEnv* env, jstring message) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_w_0, message);
    }

    // method: public static final void e(java.lang.String message)
    static void e(JNIEnv* env, jstring message) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_e_0, message);
    }

    // method: public static final void e(java.lang.String message, java.lang.Throwable e)
    static void e(JNIEnv* env, jstring message, jthrowable e) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_e_1, message, e);
    }

    // method: public static final void setLevel(com.dazecake.autodroidx.utils.Level level)
    static void setLevel(JNIEnv* env, jobject level) {
        assertInited(env);
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_setLevel_0, level);
    }


    // field: private static com.dazecake.autodroidx.utils.Level threshold
    static jobject getThreshold(JNIEnv* env) {
       assertInited(env);
       return env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_threshold_0);

    }

    // field: private static com.dazecake.autodroidx.utils.Level threshold
    static void setThreshold(JNIEnv* env, jobject threshold) {
        assertInited(env);
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_threshold_0, threshold);
    }


    // field: private static final java.io.PrintStream CONSOLE_OUT
    static jobject getCONSOLE_OUT(JNIEnv* env) {
       assertInited(env);
       return env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_OUT_1);

    }

    // field: private static final java.io.PrintStream CONSOLE_OUT
    static void setCONSOLE_OUT(JNIEnv* env, jobject CONSOLE_OUT) {
        assertInited(env);
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_OUT_1, CONSOLE_OUT);
    }


    // field: private static final java.io.PrintStream CONSOLE_ERR
    static jobject getCONSOLE_ERR(JNIEnv* env) {
       assertInited(env);
       return env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_ERR_2);

    }

    // field: private static final java.io.PrintStream CONSOLE_ERR
    static void setCONSOLE_ERR(JNIEnv* env, jobject CONSOLE_ERR) {
        assertInited(env);
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_ERR_2, CONSOLE_ERR);
    }


    // field: public static final com.dazecake.autodroidx.utils.Log INSTANCE
    static jobject getINSTANCE(JNIEnv* env) {
       assertInited(env);
       return env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_INSTANCE_3);

    }

    // field: public static final com.dazecake.autodroidx.utils.Log INSTANCE
    static void setINSTANCE(JNIEnv* env, jobject INSTANCE) {
        assertInited(env);
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_INSTANCE_3, INSTANCE);
    }


    // ====== jni helper ======
private:
    ::jenny::LocalRef<jobject> _local;
    ::jenny::GlobalRef<jobject> _global;
 
public:

    // jni helper
    ::jenny::LocalRef<jobject> getThis(bool owned = true) const {
        if (_local) {
            if (owned) {
                return _local;
            } else {
                return ::jenny::LocalRef<jobject>(_local.get(), false);
            }
        } else {
            return _global.toLocal();
        }
    }

    // jni helper constructors
    LogProxy(jobject ref, bool owned = false): _local(ref, owned) {
       assertInited(::jenny::Env().get());
    }
   
    LogProxy(::jenny::LocalRef<jobject> ref): _local(std::move(ref)) {
       assertInited(::jenny::Env().get());
    }
   
    LogProxy(::jenny::GlobalRef<jobject> ref): _global(std::move(ref)) {
       assertInited(::jenny::Env().get());
    }
   
    // construct: private Log()
    static LogProxy newInstance() {
        ::jenny::Env env; assertInited(env.get());
        return env->NewObject(getClassInitState().sClazz, getClassInitState().sConstruct_0);
    } 
    

    // for jni helper
    // method: private static final boolean isEnabled(com.dazecake.autodroidx.utils.Level level)
    static jboolean isEnabled(const ::jenny::LocalRef<jobject>& level) {
        ::jenny::Env env; assertInited(env.get());
        return env->CallStaticBooleanMethod(getClassInitState().sClazz, getClassInitState().sMethod_isEnabled_0, level.get());
    }

    // for jni helper
    // method: public static final void disableSystemStreams()
    static void disableSystemStreams() {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_disableSystemStreams_0);
    }

    // for jni helper
    // method: public static final void v(java.lang.String message)
    static void v(const ::jenny::LocalRef<jstring>& message) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_v_0, message.get());
    }

    // for jni helper
    // method: public static final void d(java.lang.String message)
    static void d(const ::jenny::LocalRef<jstring>& message) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_d_0, message.get());
    }

    // for jni helper
    // method: public static final void i(java.lang.String message)
    static void i(const ::jenny::LocalRef<jstring>& message) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_i_0, message.get());
    }

    // for jni helper
    // method: public static final void w(java.lang.String message)
    static void w(const ::jenny::LocalRef<jstring>& message) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_w_0, message.get());
    }

    // for jni helper
    // method: public static final void e(java.lang.String message)
    static void e(const ::jenny::LocalRef<jstring>& message) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_e_0, message.get());
    }

    // for jni helper
    // method: public static final void e(java.lang.String message, java.lang.Throwable e)
    static void e(const ::jenny::LocalRef<jstring>& message, const ::jenny::LocalRef<jthrowable>& e) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_e_1, message.get(), e.get());
    }

    // for jni helper
    // method: public static final void setLevel(com.dazecake.autodroidx.utils.Level level)
    static void setLevel(const ::jenny::LocalRef<jobject>& level) {
        ::jenny::Env env; assertInited(env.get());
        env->CallStaticVoidMethod(getClassInitState().sClazz, getClassInitState().sMethod_setLevel_0, level.get());
    }


        // for jni helper
    // field: private static com.dazecake.autodroidx.utils.Level threshold
    static ::jenny::LocalRef<jobject> getThreshold() {
       ::jenny::Env env; assertInited(env.get());
       return ::jenny::LocalRef<jobject>(env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_threshold_0));

    }

        // for jni helper
    // field: private static com.dazecake.autodroidx.utils.Level threshold
    static void setThreshold(const ::jenny::LocalRef<jobject>& threshold) {
        ::jenny::Env env; assertInited(env.get());
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_threshold_0, threshold.get());
    }


        // for jni helper
    // field: private static final java.io.PrintStream CONSOLE_OUT
    static ::jenny::LocalRef<jobject> getCONSOLE_OUT() {
       ::jenny::Env env; assertInited(env.get());
       return ::jenny::LocalRef<jobject>(env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_OUT_1));

    }

        // for jni helper
    // field: private static final java.io.PrintStream CONSOLE_OUT
    static void setCONSOLE_OUT(const ::jenny::LocalRef<jobject>& CONSOLE_OUT) {
        ::jenny::Env env; assertInited(env.get());
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_OUT_1, CONSOLE_OUT.get());
    }


        // for jni helper
    // field: private static final java.io.PrintStream CONSOLE_ERR
    static ::jenny::LocalRef<jobject> getCONSOLE_ERR() {
       ::jenny::Env env; assertInited(env.get());
       return ::jenny::LocalRef<jobject>(env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_ERR_2));

    }

        // for jni helper
    // field: private static final java.io.PrintStream CONSOLE_ERR
    static void setCONSOLE_ERR(const ::jenny::LocalRef<jobject>& CONSOLE_ERR) {
        ::jenny::Env env; assertInited(env.get());
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_CONSOLE_ERR_2, CONSOLE_ERR.get());
    }


        // for jni helper
    // field: public static final com.dazecake.autodroidx.utils.Log INSTANCE
    static ::jenny::LocalRef<jobject> getINSTANCE() {
       ::jenny::Env env; assertInited(env.get());
       return ::jenny::LocalRef<jobject>(env->GetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_INSTANCE_3));

    }

        // for jni helper
    // field: public static final com.dazecake.autodroidx.utils.Log INSTANCE
    static void setINSTANCE(const ::jenny::LocalRef<jobject>& INSTANCE) {
        ::jenny::Env env; assertInited(env.get());
        env->SetStaticObjectField(getClassInitState().sClazz, getClassInitState().sField_INSTANCE_3, INSTANCE.get());
    }



private:
    struct ClassInitState {
    // thread safe init
    std::atomic_bool sInited {};
    std::mutex sInitLock {};

    jclass sClazz = nullptr;
    jmethodID sConstruct_0 = nullptr;

    jmethodID sMethod_isEnabled_0 = nullptr;
    jmethodID sMethod_disableSystemStreams_0 = nullptr;
    jmethodID sMethod_v_0 = nullptr;
    jmethodID sMethod_d_0 = nullptr;
    jmethodID sMethod_i_0 = nullptr;
    jmethodID sMethod_w_0 = nullptr;
    jmethodID sMethod_e_0 = nullptr;
    jmethodID sMethod_e_1 = nullptr;
    jmethodID sMethod_setLevel_0 = nullptr;

    jfieldID sField_threshold_0 = nullptr;
    jfieldID sField_CONSOLE_OUT_1 = nullptr;
    jfieldID sField_CONSOLE_ERR_2 = nullptr;
    jfieldID sField_INSTANCE_3 = nullptr;

    }; // endof struct ClassInitState

    static inline ClassInitState& getClassInitState() {
        static ClassInitState classInitState;
        return classInitState;
    }

};





// external logger function passed by jenny.errorLoggerFunction
void jennySampleErrorLog(JNIEnv* env, const char* error);



/*static*/ inline bool LogProxy::initClazz(JNIEnv* env) {
#define JENNY_CHECK_NULL(val)                      \
       do {                                        \
           if ((val) == nullptr) {                 \
               jennySampleErrorLog(env, "can't init LogProxy::" #val); \
               return false;                       \
           }                                       \
       } while(false)

    auto& state = getClassInitState();
    if (!state.sInited) {
        std::lock_guard<std::mutex> lg(state.sInitLock);
        if (!state.sInited) {
            auto clazz = env->FindClass(FULL_CLASS_NAME);
            JENNY_CHECK_NULL(clazz);
            state.sClazz = reinterpret_cast<jclass>(env->NewGlobalRef(clazz));
            env->DeleteLocalRef(clazz);
            JENNY_CHECK_NULL(state.sClazz);

            state.sConstruct_0 = env->GetMethodID(state.sClazz, "<init>", "()V");
            JENNY_CHECK_NULL(state.sConstruct_0);


            state.sMethod_isEnabled_0 = env->GetStaticMethodID(state.sClazz, "isEnabled", "(Lcom/dazecake/autodroidx/utils/Level;)Z");
            JENNY_CHECK_NULL(state.sMethod_isEnabled_0);

            state.sMethod_disableSystemStreams_0 = env->GetStaticMethodID(state.sClazz, "disableSystemStreams", "()V");
            JENNY_CHECK_NULL(state.sMethod_disableSystemStreams_0);

            state.sMethod_v_0 = env->GetStaticMethodID(state.sClazz, "v", "(Ljava/lang/String;)V");
            JENNY_CHECK_NULL(state.sMethod_v_0);

            state.sMethod_d_0 = env->GetStaticMethodID(state.sClazz, "d", "(Ljava/lang/String;)V");
            JENNY_CHECK_NULL(state.sMethod_d_0);

            state.sMethod_i_0 = env->GetStaticMethodID(state.sClazz, "i", "(Ljava/lang/String;)V");
            JENNY_CHECK_NULL(state.sMethod_i_0);

            state.sMethod_w_0 = env->GetStaticMethodID(state.sClazz, "w", "(Ljava/lang/String;)V");
            JENNY_CHECK_NULL(state.sMethod_w_0);

            state.sMethod_e_0 = env->GetStaticMethodID(state.sClazz, "e", "(Ljava/lang/String;)V");
            JENNY_CHECK_NULL(state.sMethod_e_0);

            state.sMethod_e_1 = env->GetStaticMethodID(state.sClazz, "e", "(Ljava/lang/String;Ljava/lang/Throwable;)V");
            JENNY_CHECK_NULL(state.sMethod_e_1);

            state.sMethod_setLevel_0 = env->GetStaticMethodID(state.sClazz, "setLevel", "(Lcom/dazecake/autodroidx/utils/Level;)V");
            JENNY_CHECK_NULL(state.sMethod_setLevel_0);


            state.sField_threshold_0 = env->GetStaticFieldID(state.sClazz, "threshold", "Lcom/dazecake/autodroidx/utils/Level;");
            JENNY_CHECK_NULL(state.sField_threshold_0);

            state.sField_CONSOLE_OUT_1 = env->GetStaticFieldID(state.sClazz, "CONSOLE_OUT", "Ljava/io/PrintStream;");
            JENNY_CHECK_NULL(state.sField_CONSOLE_OUT_1);

            state.sField_CONSOLE_ERR_2 = env->GetStaticFieldID(state.sClazz, "CONSOLE_ERR", "Ljava/io/PrintStream;");
            JENNY_CHECK_NULL(state.sField_CONSOLE_ERR_2);

            state.sField_INSTANCE_3 = env->GetStaticFieldID(state.sClazz, "INSTANCE", "Lcom/dazecake/autodroidx/utils/Log;");
            JENNY_CHECK_NULL(state.sField_INSTANCE_3);


            state.sInited = true;
        }
    }
#undef JENNY_CHECK_NULL
   return true;
}

/*static*/ inline void LogProxy::releaseClazz(JNIEnv* env) {
    auto& state = getClassInitState();
    if (state.sInited) {
        std::lock_guard<std::mutex> lg(state.sInitLock);
        if (state.sInited) {
            env->DeleteGlobalRef(state.sClazz);
            state.sClazz = nullptr;
            state.sInited = false;
        }
    }
}


