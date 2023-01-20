package ble.ble.littlelemoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ble.ble.littlelemoncompose.ui.theme.LittleLemonComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           LittleLemonComposeTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colors.background
               ){
                   MainComponent()
               }
           }
        }
    }
}


@Composable
fun MainComponent(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF495E57)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 32.sp,
            color = Color(0XFFF4CE14),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 32.sp,
            color = Color(0XFFFFFFFF),
            modifier = Modifier.padding(start = 20.dp)
        )

        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.description)
            )
            Image(
                painter = painterResource(id = R.drawable.lemon),
                contentDescription = "",
                Modifier.height(100.dp)
            )
        }
        Button(onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFF4CE14))
        ) {
            Text(text = stringResource(id = R.string.order)
                ,fontSize = 32.sp)
        }
    }
}
//@Composable
//fun RestaurantName(name: String, size: Int){
//    Text(
//        text = name,
//        fontSize = size.sp
//    )
//}
//


@Preview(showBackground = true)
@Composable
fun MainComponentPreview() {
    LittleLemonComposeTheme {
        MainComponent()
    }
}