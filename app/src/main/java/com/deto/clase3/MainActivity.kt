package com.deto.clase3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.deto.clase3.ui.theme.Clase3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clase3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )

                        Greeting2(
                            clase = 3
                        )

                        Imagen1()

                        Imagen2(R.drawable._dd8f0629_5c04_4090_8869_e444f87a02dd_)

                        Calculadora(5.0,5.0,"suma")
                        Calculadora(5.0,5.0,"division")
                        Calculadora(5.0,5.0,"multiplicacion")
                        Calculadora(5.0,5.0,"resta")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clase3Theme {
        Greeting("Android")
    }
}

@Composable
fun Greeting2(clase: Int ){
    Log.d("saludo","se renderizo la funcion saludo")

    Text(
        text = "Hola, esta es la clase $clase",

    )
}

@Composable
fun Imagen1(){
    Image(painter = painterResource( id = R.drawable._42f493d7_9ac3_4a06_b127_29272ea78b9e_), contentDescription = "gallo")
}

@Composable
fun Imagen2( identificador: Int ){
    Log.d("imagenGato","Esta es la imagen de un gato")
    Image(painter = painterResource( id = identificador), contentDescription = "gato")
}

@Composable
fun Calculadora( a: Double, b: Double, operacion: String ){

    fun suma( x: Double, y: Double ): Double{
        return x + y
    }

    fun resta( x: Double, y: Double ): Double{
        return x - y
    }

    fun division( x: Double, y: Double ): Double?{
        if( y != 0.0 ){
            return x/y
        }
        else{
            return null
        }
    }
    fun multiplicacion( x: Double, y: Double ): Double{
        return x * y
    }

    when(operacion){
        "suma" -> Text( text = "La operacion $operacion de $a y $b resulta en ${suma(a, b)}")
        "resta" -> Text( text = "La operacion $operacion de $a y $b resulta en ${resta(a,b)}")
        "division" -> Text( text = "La operacion $operacion de $a y $b resulta en ${division(a,b)}")
        "multiplicacion" -> Text( text = "La operacion $operacion de $a y $b resulta en ${multiplicacion(a,b)}")
        else -> null
    }

    Log.d("Calculadora","Operacion: $operacion, Numeros involucrados: $a y $b, resultado:")

}