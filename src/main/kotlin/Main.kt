import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

@Composable
@Preview
fun PrimeraVentana(onCerrarventana: () -> Unit,onCambiarVentanas: () -> Unit ) {
    Window(onCloseRequest = onCerrarventana) {
        MaterialTheme {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = onCambiarVentanas) {
                    Text("Abrir Ventana Secundaria y Cerrar esta")
                }
            }
        }

    }
}

@Composable
@Preview
fun SegundaVentana(onCerrarventana: () -> Unit,onCambiarVentanas: () -> Unit ) {
    Window(onCloseRequest = onCerrarventana) {
        MaterialTheme {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = onCambiarVentanas) {
                    Text("Abrir Ventana Primaria y Cerrar esta")
                }
            }
        }

    }
}

fun main() = application {
    var primeraVentana by remember { mutableStateOf(true) }
    var segundaVentana by remember { mutableStateOf(false) }

    if(primeraVentana) {
        PrimeraVentana(
            {primeraVentana = false}
        ) {
            primeraVentana = false
            segundaVentana = true
        }
    }

    if (segundaVentana) {
        SegundaVentana(
            {segundaVentana = false}
        ) {
            primeraVentana = true
            segundaVentana = false
        }
    }

    if(!primeraVentana && !segundaVentana) {
        exitApplication()
    }


}
