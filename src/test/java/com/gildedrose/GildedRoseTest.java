package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    GildedRose app;

    @Test
    void whenItemIsAgedBrie_QualityShouldIncreaseByOne() {
        final Item[] items = new Item[]{new Item("Aged Brie", 30, 49)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void whenItemDoesNotHaveSpecialQualityRequirements_QualityAndSellInShouldDecreaseByOne() {
        final Item[] items = new Item[]{new Item("Not special", 30, 49)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Not special", app.items[0].name);
        assertEquals(48, app.items[0].quality);
        assertEquals(29, app.items[0].sellIn);
    }

    @Test
    void whenItemDoesNotHaveSpecialQualityRequirements_AndSellInDateAsPassed_QualityShouldDegradeTwiceAsFast() {
        final Item[] items = new Item[]{new Item("Not special", 0, 49)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Not special", app.items[0].name);
        assertEquals(47, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void whenItemDoesNotHaveSpecialQualityRequirements_QualityShouldNotBeNegative() {
        final Item[] items = new Item[]{new Item("Not special", 0, 1)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Not special", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void QualityShouldNotGoOver50() {
        final Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void whenItemIsSulfuras_SellInAndQualityShouldNotDecrease() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void whenItemIsBackStagePasses_SellInAndQualityShouldIncreaseBy2IfSellInIsBetween10And6() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(12, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void whenItemIsBackStagePasses_SellInAndQualityShouldIncreaseBy3IfSellInIs5OrLess() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 12)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(15, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void whenItemIsConjured_QualityShouldDegradeTwiceAsFastAsOtherItems() {
        final Item[] items = new Item[]{new Item("Conjured", 4, 12)};
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(10, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }


}
