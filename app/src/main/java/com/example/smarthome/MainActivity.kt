package com.example.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                        SmartHomeApp(
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                }

            }


        }
    }
}
@Composable
fun SmartHomeApp(modifier: Modifier = Modifier
    .fillMaxSize()){
    Text(stringResource(R.string.SmartHome_intro))
    SmartTvDeviceApp()
    SmartphoneDeviceApp()
    SmartLightDeviceApp()

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


    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) { Text(stringResource(R.string.Tv_Seccion))

        Image(
        painter = painterResource(R.drawable.televisor_samsung_apagado_ps),
            contentDescription = "Apagado"
        )


        Row(modifier = modifier) {
            //Estado del dispositivo:
            Text(televisorSamsung.obtenerEstado())
            //Canal Actual
            Text(televisorSamsung.obtenerNumeroCanal())
            //Volumen Actual
            Text(televisorSamsung.obtenerTvVolumen())
        }

        Row( modifier = modifier) {
            //Row para cambiar estado
            Row {
                Button(onClick = {/*TODO*/}) {
                Text(stringResource(R.string.Encender))

                Button(onClick = {/*TODO*/}) {
                    Text(stringResource(R.string.Apagar))}

                    //Row para cambiar canal
                    Row {
                        Button(onClick = {/*TODO*/}) {
                            Text(stringResource(R.string.aumentarCanal)) }

                        Button(onClick = {/*TODO*/}) {
                            Text(stringResource(R.string.disminuirCanal)) }

                    }
                    //Row para cambiar Volumen

                    Row {
                        Button(onClick = {/*TODO*/}) {
                            Text(stringResource(R.string.aumentarVolumen)) }

                        Button(onClick = {/*TODO*/}) {
                            Text(stringResource(R.string.disminuirVolumen))
                }
                }
            }
        }


       // var estarEncendido by remember { mutableStateOf(false)}

        }


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
fun SmartHomeAppPreview(){
    SmartHomeTheme {
        SmartHomeApp()
    }

}