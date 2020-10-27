package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            fun reduceItemQuality(){
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }
            if (item.name == "Aged Brie") {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
                item.sellIn = item.sellIn - 1
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                }
                item.sellIn = item.sellIn - 1
                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality
                }
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
            } else if (item.name.startsWith("Conjured")) {
                reduceItemQuality()
                reduceItemQuality()
                item.sellIn = item.sellIn - 1
                if (item.sellIn < 0) {
                    reduceItemQuality()
                    reduceItemQuality()
                }
            } else {
                reduceItemQuality()
                item.sellIn = item.sellIn - 1
                if (item.sellIn < 0) {
                    reduceItemQuality()
                }
            }
        }
    }

}

