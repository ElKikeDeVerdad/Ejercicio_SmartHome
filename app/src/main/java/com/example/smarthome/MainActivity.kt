package com.example.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarthome.model.SmartLightDevice
import com.example.smarthome.model.SmartTvDevice
import com.example.smarthome.model.SmartphoneDevice
import com.example.smarthome.ui.theme.SmartHomeTheme


class MainActivit : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartHomeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SmartHomeTheme {
                        SmartHomeApp(
                            modifier = Modifier
                            .padding(innerPadding))
                    } }

                }



        }
    }
@Composable
fun SmartHomeApp(modifier: Modifier = Modifier
    .fillMaxSize()){
    Text(stringResource(R.string.SmartHome_intro))
    SmartHomeApp(modifier = Modifier)
    SmartTvDeviceApp(modifier =  Modifier)
    SmartphoneDeviceApp()
    SmartLightDeviceApp()

    }

}
@Composable
fun BackgroundImage(){
    //Image(
     //   painter = painterResource(),
     //   contentDescription = null
   // )
}


@Composable
fun SmartTvDeviceApp(modifier: Modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()){

    val televisorSamsung = SmartTvDevice("SamsungSmartTV", "Televisor", "Fijo", "Apagado")

    //var estarEncendido by remember { mutableStateOf(false)}

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        televisorSamsung.turnOn()

        Text("Bienvenido a la sección de SmartTv")
        //Estado del dispositivo:

    Text("${televisorSamsung.obtenerEstado()}")









   //Image(
        //painter = painterResource(),
   //     contentDescription = "Apagado"
   // )
    }

}

@Composable
fun SmartphoneDeviceApp(modifier: Modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(0.3f)){


    }


@Composable
fun SmartLightDeviceApp(){}


@Preview(showBackground = true)
@Composable
fun SmartHomeApp(){
    SmartTvDeviceApp()
}