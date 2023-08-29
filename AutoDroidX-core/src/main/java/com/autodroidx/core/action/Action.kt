package com.autodroidx.core.action

/**
 * 操作接口，为了方便调用以委托的方式实现各种功能，基于设备的功能都应该在这里实现委托代理
 * 具体做法是先抽象一个Delegate接口，然后在实现类中实现接口，最后在这里委托实现类
 *
 */
interface Action

inline fun Action.use(block: Action.() -> Unit) {
    block()
}
