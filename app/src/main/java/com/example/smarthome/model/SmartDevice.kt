package com.example.smarthome.model

open class SmartDevice(val name: String, val category: String, val mobility: String) {

    //hago un enum class, asi evitar tener que hacer un var por cada estado
    //enum class no es subclase, puede ir fuera en un archivo auxiliar file.kt,
    //si se necesita usar en clases que no hereden la superclase

    enum class DeviceStatus {
        ENCENDIDO, APAGADO, ONLINE, OFFLINE, DESCONOCIDO
    }
    //en vez de hacer un var deviceStatus: String = "Encendido", se usa el enum class

    //se usa DeviceStatus.APAGADO como default, puede ser cualquiera
    protected var deviceStatus: DeviceStatus = DeviceStatus.APAGADO


    //Como necesito hacer un ENCENDIDO, APAGADO a la propiedad tengo que hacerle un constructor
    //necesita varias maneras de llamarse dependiendo del estado (encendido, apagado)
    constructor(name: String, category: String, mobility: String, statusCode: Int)
            : this(name, category, mobility) {
        deviceStatus = when (statusCode) {
            0 -> DeviceStatus.APAGADO
            1 -> DeviceStatus.ENCENDIDO
            10 -> DeviceStatus.OFFLINE
            11 -> DeviceStatus.ONLINE

            else -> DeviceStatus.DESCONOCIDO

        }
    }

    open fun turnOn() {
        deviceStatus = DeviceStatus.ENCENDIDO
    }

    open fun turnOff() {
        deviceStatus = DeviceStatus.APAGADO
    }

    open fun conectadoInternet() {
        deviceStatus = DeviceStatus.ONLINE
    }

    open fun desconectadoInternet() {
        deviceStatus = DeviceStatus.OFFLINE
    }

    //Esto es para poder imprimir el estado del dispositivo ya que deviceStatus es privado
    fun obtenerEstado(): String {
        return when (deviceStatus) {
            DeviceStatus.ENCENDIDO -> "El dispositivo esta: ENCENDIDO"
            DeviceStatus.APAGADO -> "El dispositivo esta: APAGADO"
            DeviceStatus.ONLINE -> "El dispositivo esta: ONLINE"
            DeviceStatus.OFFLINE -> "El dispositivo esta: ENCENDIDO"
            DeviceStatus.DESCONOCIDO -> "Se desconoce la situación de su dispositivo"
        }

        //hago un buleano para usar despues, no imprime nada solo da un true o false para su uso
        //Ejemplo: Imprimir un mensaje cuando este encendido, o que realice una actividad.

        fun isOn(): Boolean {
            return deviceStatus == DeviceStatus.ENCENDIDO
        }

        fun isOff(): Boolean {
            return deviceStatus == DeviceStatus.APAGADO
        }

    }
}




