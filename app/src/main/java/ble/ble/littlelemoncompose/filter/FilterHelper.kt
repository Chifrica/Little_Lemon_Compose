package ble.ble.littlelemoncompose.filter

import ble.ble.littlelemoncompose.menu.ProductItem

class FilterHelper {//TODO create a FilterHelperTest and write a unit test for filterProducts

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList

            // TODO("only products with category equal to Dessert")
            FilterType.Dessert -> productsList.filter {
                it.category == "Dessert"
            }

            // TODO("only products with category equal to Drinks")
            FilterType.Drinks -> productsList.filter {
                it.category == "Drinks"
            }

            // TODO("only products with category equal to Food")
            FilterType.Food -> productsList.filter {
                it.category == "Food"
            }
        }
    }

}