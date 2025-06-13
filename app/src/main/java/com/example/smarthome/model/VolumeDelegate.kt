package com.example.smarthome.model

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class VolumeDelegate: ReadWriteProperty<Any?, Int> {
    private var field: Int = 10
    override fun getValue (thisRef: Any?, property: KProperty<*>) :Int {
        return field
    }
    override fun setValue (thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in 0..100)
            field = value
        else {
            println("El volumen esta fuera del rango $value (entre 0 y 100)")
        }
    }
}