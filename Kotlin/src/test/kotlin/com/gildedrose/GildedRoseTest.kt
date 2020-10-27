package com.gildedrose

import org.approvaltests.Approvals.verifyAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun goldenMaster() {
        val items = genarateItems()
        val app = GildedRose(items)
        app.updateQuality()
        verifyAll("items", items)
    }

    private fun genarateItems(): Array<Item> {
        return arrayOf(Item("foo", 0, 0))
    }

}


