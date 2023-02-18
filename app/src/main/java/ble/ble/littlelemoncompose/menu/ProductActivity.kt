package ble.ble.littlelemoncompose.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra(KEY_TITLE).orEmpty()
        val price = intent.getDoubleExtra(KEY_PRICE, 0.00)
        val image = intent.getIntExtra(KEY_IMAGE, 0)
        val category = intent.getStringExtra(KEY_CATEGORY).orEmpty()

        val productItem =
            ProductItem(title, price, category, image)//todo replace with the passed values from intent
        setContent { ProductDetails(productItem) }
    }

    companion object{
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}