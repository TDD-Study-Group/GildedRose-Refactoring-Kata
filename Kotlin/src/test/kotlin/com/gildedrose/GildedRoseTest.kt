package com.gildedrose

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
        val items = arrayOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        org.approvaltests.Approvals.verifyAll("items", items)
    }

}


