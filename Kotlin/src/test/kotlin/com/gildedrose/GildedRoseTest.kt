package com.gildedrose

import org.approvaltests.Approvals.verifyAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class GildedRoseTest {
    private val random = Random(100)

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun conjuredItem() {
        val items = arrayOf(Item("Conjured Mana Cake", 3, 6))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun conjuredItemWithNegativSellIn() {
        val items = arrayOf(Item("Conjured Mana Cake", -1, 6))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(2, app.items[0].quality)
    }


    @Test
    fun goldenMaster() {
        val items = genarateItems(10000)
        val app = GildedRose(items)
        app.updateQuality()
        verifyAll("items", items)
    }

    private fun genarateItems(count: Int): Array<Item> {
        return (0..count).map { generateItem() }.toTypedArray()
    }

    private fun generateItem() = Item(generateName(), generateSellIn(), generateQuality())

    private fun generateQuality(): Int {
        return random.nextInt(-500, 500)
    }

    private fun generateName(): String {
        val possibleNames = listOf("foo", "Aged Brie", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert")
        return possibleNames[random.nextInt(0, possibleNames.size)]
    }

    private fun generateSellIn(): Int {
        return random.nextInt(-500, 500)
    }

}


