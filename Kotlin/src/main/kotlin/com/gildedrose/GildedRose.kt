package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            when {
                item.name == "Aged Brie" -> AgedBrie(item)
                item.name == "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item)
                item.name == "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
                item.name.startsWith("Conjured") -> Conjured(item)
                else -> Normal(item)
            }.update()
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

    protected fun reachedSellIn() = item.sellIn < 0

    abstract fun update()
}

class AgedBrie(item: Item) : ItemAdapter(item) {

    override fun update() {
        increaseQuality()
        reduceSellIn()
        if (reachedSellIn()) increaseQuality()
    }
}

class BackstagePass(item: Item) : ItemAdapter(item) {
    override fun update() {
        increaseQuality()
        if (lessThanElevenDaysLeft()) increaseQuality()
        if (lessThanSixDaysLeft()) increaseQuality()
        reduceSellIn()
        if (reachedSellIn()) reduceToMinimumQuality()
    }

    private fun reduceToMinimumQuality() {
        item.quality = 0
    }

    private fun lessThanSixDaysLeft() = item.sellIn < 6

    private fun lessThanElevenDaysLeft() = item.sellIn < 11
}

class Sulfuras(item: Item) : ItemAdapter(item) {
    override fun update() {}
}

class Conjured(item: Item) : ItemAdapter(item) {
    override fun update() {
        reduceQualityTwiceAsOften()
        reduceSellIn()
        if (reachedSellIn()) {
            reduceQualityTwiceAsOften()
        }
    }

    private fun reduceQualityTwiceAsOften() {
        reduceQuality()
        reduceQuality()
    }
}

class Normal(item: Item) : ItemAdapter(item) {
    override fun update() {
        reduceQuality()
        reduceSellIn()
        if (reachedSellIn()) {
            reduceQuality()
        }
    }
}
