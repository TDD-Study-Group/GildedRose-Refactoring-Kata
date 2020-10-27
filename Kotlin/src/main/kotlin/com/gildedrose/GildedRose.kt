package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item) {
        fun reduceQuality() {
            if (item.quality > 0) item.quality = item.quality - 1
        }

        fun increaseQuality() {
            if (item.quality < 50) item.quality = item.quality + 1
        }

        fun reduceSellIn() {
            item.sellIn = item.sellIn - 1
        }

        if (item.name == "Aged Brie") {
            increaseQuality()
            reduceSellIn()
            if (item.sellIn < 0) increaseQuality()
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            increaseQuality()
            if (item.sellIn < 11) increaseQuality()
            if (item.sellIn < 6) increaseQuality()
            reduceSellIn()
            if (item.sellIn < 0) item.quality = 0
        } else if (item.name == "Sulfuras, Hand of Ragnaros") {
        } else if (item.name.startsWith("Conjured")) {
            reduceQuality()
            reduceQuality()
            reduceSellIn()
            if (item.sellIn < 0) {
                reduceQuality()
                reduceQuality()
            }
        } else {
            reduceQuality()
            reduceSellIn()
            if (item.sellIn < 0) {
                reduceQuality()
            }
        }
    }


}

