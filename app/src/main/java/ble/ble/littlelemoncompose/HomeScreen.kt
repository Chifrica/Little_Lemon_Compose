package ble.ble.littlelemoncompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController


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
