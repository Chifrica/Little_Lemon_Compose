package ble.ble.littlelemoncompose.util

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import ble.ble.littlelemoncompose.LowerPanel
import ble.ble.littlelemoncompose.data.DishRepository


@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        TopAppBar()
        UpperPanel()
        LowerPanel(navController, DishRepository.dishes)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    TopAppBar()
    UpperPanel()
}
