package com.gxd.viewbindingwrapper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

object ViewBindingUtil {
    fun <T : ViewBinding> getViewBindingClass(any: Any): Class<T>? {
        val superClass = any::class.java.genericSuperclass
        if (superClass is ParameterizedType) {
            for (typeArgument in superClass.actualTypeArguments) {
                if (typeArgument is Class<*> && ViewBinding::class.java in typeArgument.interfaces) {
                    return typeArgument as Class<T>?
                }
            }
        }
        return null
    }
}

fun <T : ViewBinding> Class<T>.callInflate(
    inflater: LayoutInflater,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): T? {
    val inflateMethod = getMethod(
        "inflate",
        LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java
    )
    return inflateMethod.invoke(null, inflater, parent, attachToParent) as T?
}