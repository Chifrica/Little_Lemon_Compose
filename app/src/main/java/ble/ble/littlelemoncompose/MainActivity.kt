package ble.ble.littlelemoncompose

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.MenuCompat
import ble.ble.littlelemoncompose.filter.FilterHelper
import ble.ble.littlelemoncompose.filter.FilterType
import ble.ble.littlelemoncompose.menu.ProductActivity
import ble.ble.littlelemoncompose.menu.ProductActivity.Companion.KEY_CATEGORY
import ble.ble.littlelemoncompose.menu.ProductActivity.Companion.KEY_IMAGE
import ble.ble.littlelemoncompose.menu.ProductActivity.Companion.KEY_PRICE
import ble.ble.littlelemoncompose.menu.ProductActivity.Companion.KEY_TITLE
import ble.ble.littlelemoncompose.menu.ProductItem
import ble.ble.littlelemoncompose.menu.Products
import ble.ble.littlelemoncompose.menu.ProductsGrid
import ble.ble.littlelemoncompose.menu.ProductsWarehouse.productsList
import ble.ble.littlelemoncompose.sort.SortHelper
import ble.ble.littlelemoncompose.sort.SortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    private val productsState: MutableStateFlow<Products> =
        MutableStateFlow(Products(productsList))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InitUI() }
    }

    @Composable
    fun InitUI() {
        val products by productsState.collectAsState()
        // AM not sure of what i put down
        ProductsGrid(products = products, startProductActivity = this::startProductActivity)
    }

    private fun startProductActivity(productItem: ProductItem) {
        //TODO instantiate intent and pass extra parameter from product
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra(KEY_TITLE, productItem.title)
        intent.putExtra(KEY_PRICE, productItem.price)
        intent.putExtra(KEY_IMAGE, productItem.image)
        intent.putExtra(KEY_CATEGORY, productItem.category)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.products_menu, menu)
        //In the menu parameter below i added non-null asserted in replace of menu
        MenuCompat.setGroupDividerEnabled(menu!!, true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == R.id.sorting) {
            val type = when (item.itemId) {
                R.id.sort_a_z -> SortType.Alphabetically
                R.id.sort_price_asc -> SortType.PriceAsc
                R.id.sort_price_desc -> SortType.PriceDesc
                else -> SortType.Alphabetically
            }
            productsState.update {
                Products(
                    SortHelper().sortProducts(
                        type,
                        productsList
                    )
                )
            }
        } else if (item.groupId == R.id.filter) {
            val type = when (item.itemId) {
                R.id.filter_all -> FilterType.All
                R.id.filter_drinks -> FilterType.Drinks
                R.id.filter_food -> FilterType.Food
                R.id.filter_dessert -> FilterType.Dessert
                else -> FilterType.All
            }
            productsState.update {
                Products(
                    FilterHelper().filterProducts(
                        type,
                        productsList
                    )
                )
            }
        }
        return true
    }
}