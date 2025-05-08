package com.example.lista_desplegable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lista_desplegable.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ComidasList()
            }
        }
    }
}

data class Comida(
    val dia: Int,
    val titulo: String,
    val descripcion: String,
    val imagen: Int // Debes reemplazar esto con tus propias imágenes en drawable
)

val listaComidas = listOf(
    Comida(1, "Lasaña de carne", "Capas de pasta con carne molida, salsa de tomate y queso gratinado.", R.drawable.lasana),
    Comida(2, "Pollo al horno con papas", "Pollo sazonado y horneado acompañado de papas doradas y verduras.", R.drawable.pollo_horno),
    Comida(3, "Ensalada César", "Lechuga fresca, crutones, queso parmesano y aderezo César.", R.drawable.ensalada_cesar),
    Comida(4, "Arroz chaufa", "Arroz frito al estilo oriental con pollo, huevo y salsa de soya.", R.drawable.arroz_chaufa),
    Comida(5, "Tallarines a la huancaína", "Tallarines bañados en salsa huancaína con huevo y aceitunas.", R.drawable.tallarines_huancaina),
    Comida(6, "Seco de res", "Carne de res cocida a fuego lento con culantro, servida con frijoles y arroz.", R.drawable.seco_res),
    Comida(7, "Sopa de pollo casera", "Caldo nutritivo con pollo, verduras y fideos.", R.drawable.sopa_pollo),
    Comida(8, "Pescado frito con ensalada", "Filete de pescado crujiente acompañado de ensalada fresca.", R.drawable.pescado_frito),
    Comida(9, "Lomo saltado", "Trozos de carne salteados con cebolla, tomate y papas fritas.", R.drawable.lomo_saltado),
    Comida(10, "Tacu tacu con bistec", "Mezcla de arroz y frijoles dorados, servido con un jugoso bistec.", R.drawable.tacu_tacu)
)

@Composable
fun ComidasList() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = "30 ideas de comidas",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(listaComidas) { comida ->
                    ComidaItem(comida)
                }
            }
        }
    }
}

@Composable
fun ComidaItem(comida: Comida) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Día ${comida.dia}", fontSize = 18.sp, modifier = Modifier.padding(bottom = 4.dp))
        Text(text = comida.titulo, fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
        Image(
            painter = painterResource(id = comida.imagen),
            contentDescription = comida.titulo,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = comida.descripcion, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComidasList() {
    ComidasList()
}
