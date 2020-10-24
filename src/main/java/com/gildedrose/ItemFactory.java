package com.gildedrose;

public class ItemFactory {

    protected Item getItem(final String itemName, final int sellIn, final int quality) {
        switch (itemName) {
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            default:
                return new Item(itemName, sellIn, quality);
        }
    }
}
