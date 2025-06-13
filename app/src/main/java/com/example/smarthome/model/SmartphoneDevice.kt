package com.example.smarthome.model

class SmartphoneDevice(name: String, category: String, mobility: String) : SmartDevice(name, category, mobility) {

    private var nivelPhoneBrillo by BrightnessDelegate()
    private var altavozPhoneVolumen by VolumeDelegate()

    override fun turnOn() {
        super.turnOn()
        println("Su Smartphone esta $deviceStatus")
    }

    override fun turnOff() {
        super.turnOff()
        println("Su Smartphone esta $deviceStatus")
    }

    override fun conectadoInternet() {
        super.conectadoInternet()
        println("Su $name esta encendido $deviceStatus")
    }

    override fun desconectadoInternet() {
        super.desconectadoInternet()
        println("Su $name esta encendido $deviceStatus")
    }

    fun obtenerPhoneVolumen(): Int = altavozPhoneVolumen

    fun subirVolumen(){
        if(altavozPhoneVolumen < 100){
            altavozPhoneVolumen++
        println("El volumen ha subido a $altavozPhoneVolumen")}
        else{
            println("El volumen ya esta al maximo(100)")}

    }

    fun bajarVolumen(){
        if(altavozPhoneVolumen > 0){
            altavozPhoneVolumen--
        println("El volumen ha bajado a $altavozPhoneVolumen")}
        else {
            println("El volumen no puede ser mas bajo que el valor de 0")
        }
    }

    fun obtenerPhoneBrillo(): Int = nivelPhoneBrillo

    fun subirBrillo(){
        if(nivelPhoneBrillo < 100){
            nivelPhoneBrillo++
        println("El nivel de brillo ha subido a $nivelPhoneBrillo")}
        else {
            println("El nivel de brillo ya esta al maximo de 100")
        }
    }

    fun bajarBrillo(){
        if( nivelPhoneBrillo> 0){
            nivelPhoneBrillo--
            println("El brillo ha bajado a $nivelPhoneBrillo")}
            else{
                println("El brillo no puede bajar de 0")
            }
        }
}
