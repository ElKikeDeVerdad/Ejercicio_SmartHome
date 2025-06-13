package com.example.smarthome.model

class SmartTvDevice (name: String, category: String, mobility: String, deviceStatus: String) :
    SmartDevice (name, category, mobility,) {

    override fun turnOn() {
        super.turnOn()
        println("Su $category $mobility $name esta $deviceStatus")
    }

    override fun turnOff() {
        super.turnOff()
        println("Su $category $mobility $name esta $deviceStatus")
    }

    private var altavozTvVolumen by VolumeDelegate()
    fun obtenerTvVolumen(): Int = altavozTvVolumen



    fun subirVolumen() {
        if (altavozTvVolumen < 100) {
            altavozTvVolumen++
            println("El volumen a aumentado a $altavozTvVolumen")
        } else {
            println("El volumen ya está al máximo (100)")
        }
    }

    fun bajarVolumen() {
        if (altavozTvVolumen > 0) {
            altavozTvVolumen--
            println("El volumen se a reducido a $altavozTvVolumen")
        } else {
            println("El volumen ya está en el mínimo (0)")
        }
    }


    private var numeroCanal: Int = 3
        set(value) {
            if (value in 1..5) {
                field = value
            } else {
                println(" El canal $value no es válido, debe estar entre 0 y 200.")
            }
        }
    fun obtenerNumeroCanal(): Int = numeroCanal

    fun siguienteCanal() {
        numeroCanal++
        if (numeroCanal < 200) {
            println("Canal $numeroCanal")
        } else {
            println("El canal ya esta al maximo 200")
        }
    }

    fun anteriorCanal() {
        numeroCanal--
        if (numeroCanal > 0) {
            println("Canal $numeroCanal")
        } else {
            println("El canal ya esta al minimo 0")
        }
    }
}