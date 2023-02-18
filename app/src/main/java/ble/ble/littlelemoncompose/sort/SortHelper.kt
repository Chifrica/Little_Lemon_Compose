package ble.ble.littlelemoncompose.sort

import ble.ble.littlelemoncompose.menu.ProductItem

class SortHelper {

    fun sortProducts(type: SortType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            // either sortAlphabetically() or sortedBy{it.title}
            SortType.Alphabetically -> productsList.sortAlphabetically()

            // TODO("create extension function for List<Product> with sorting based on price ascending")
            SortType.PriceAsc -> productsList.sortedBy {
                it.price
            }

            // TODO("create extension function for List<Product> with sorting based on price descending")
            SortType.PriceDesc -> productsList.sortedByDescending {
                it.price
            }
        }
    }

    private fun List<ProductItem>.sortAlphabetically(): List<ProductItem> {
        return sortedBy { it.title }
    }

}