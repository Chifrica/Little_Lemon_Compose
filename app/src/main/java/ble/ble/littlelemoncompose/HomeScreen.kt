package ble.ble.littlelemoncompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ble.ble.littlelemoncompose.ui.theme.LittleLemonComposeTheme


@Composable
fun UpperPanel(){
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
            .background(Color(0xFF495E57))
    ){
        Text(
            text = stringResource(id = R.string.title),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0XFFF4CE14),
            modifier = Modifier.padding(start = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.location),
            fontSize = 32.sp,
            color = Color(0XFFFFFFFF),
            modifier = Modifier.padding(start = 20.dp)
        )
        
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier
                    .padding(bottom = 28.dp)
                    .fillMaxWidth(0.6f),
                fontSize = 18.sp,
                color = Color(0xFFEDEFEE)
            )

            Image(
                painter = painterResource(id = R.drawable.lemon),
                contentDescription = "Upper panel image",
                Modifier
                    .clip(RoundedCornerShape(20.dp)),
            )
        }

        Button(
            onClick = {
                Toast.makeText(context, "Order successful", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFF4CE14))
        ) {
            Text(
                text = stringResource(id = R.string.order),
                fontWeight = FontWeight.Bold
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    LittleLemonComposeTheme {
        UpperPanel()
    }
}