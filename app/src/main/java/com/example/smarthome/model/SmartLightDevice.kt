package com.example.smarthome.model

class SmartLightDevice(name: String, category: String, mobility: String, deviceStatus: String)
    :SmartDevice(name, category, mobility,){

    override fun turnOn() {
        super.turnOn()
        println("Su $category $mobility $name esta $deviceStatus")
    }
    override fun turnOff() {
        super.turnOff()
        println("Su $category $mobility $name esta $deviceStatus")
    }
private var nivelBrillo by BrightnessDelegate()
    fun obtenerBrillo(): Int {
        println("El brillo de su $category $name es $nivelBrillo")
        return nivelBrillo
    }

    fun subirBrillo(){
        if (nivelBrillo < 100){
            nivelBrillo = nivelBrillo ++
            print("El brillo ha aumentado a $nivelBrillo")}
        else{println("El nivel de brillo ya esta al maximo 100")}
    }

    fun bajarBrillo(){
        if(nivelBrillo > 0 ){
         nivelBrillo --
        print("El brillo ha bajado a $nivelBrillo")}
    else{
        println("El brillo ya esta al minimo 0")}
    }


}