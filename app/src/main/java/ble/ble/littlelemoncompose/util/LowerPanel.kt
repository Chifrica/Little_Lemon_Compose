package ble.ble.littlelemoncompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ble.ble.littlelemoncompose.data.Dish
import ble.ble.littlelemoncompose.data.DishDetails

@Composable
fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()){
  Column{
      WeeklySpecialCard()
      LazyColumn{
          itemsIndexed(dishes){ _, dish ->
              MenuDish(navController, dish)
          }
      }
  }
}

@Composable
fun WeeklySpecialCard(){
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.weekly_special),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish){
    Card(onClick = {
        Log.d("AAA", "CLick ${dish.id}")
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        Row(
            modifier = Modifier.fillMaxWidth(.75f)
                .padding(top = 5.dp, bottom = 5.dp)
        ){
            Column{
                Text(text = dish.name)
                Text(text = dish.description)
                Text(text = "$${dish.price}")
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = "Image dish",
                Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 9.dp),
        thickness = 1.dp,
        color = Color.Yellow
    )
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    WeeklySpecialCard()
}