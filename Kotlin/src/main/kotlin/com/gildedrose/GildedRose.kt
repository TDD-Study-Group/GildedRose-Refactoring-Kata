package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            val itemType: ItemAdapter = if (item.name == "Aged Brie") {
                AgedBrie(item)
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                BackstagePass(item)
            } else {
                Normal(item)
            }
            itemType.update()
        }
    }
}


sealed class ItemAdapter(val item: Item) {
    protected fun reduceQuality() {
        if (item.quality > 0) item.quality = item.quality - 1
    }

    protected fun increaseQuality() {
        if (item.quality < 50) item.quality = item.quality + 1
    }

    protected fun reduceSellIn() {
        item.sellIn = item.sellIn - 1
    }

    open fun update() {
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
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

class AgedBrie(item: Item) : ItemAdapter(item) {
    override fun update() {
        increaseQuality()
        reduceSellIn()
        if (item.sellIn < 0) increaseQuality()
    }
}

class Normal(item: Item) : ItemAdapter(item) {}
