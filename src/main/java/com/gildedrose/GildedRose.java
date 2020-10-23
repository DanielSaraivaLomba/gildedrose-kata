package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
                switch (item.name) {
                    case "Aged Brie":
                        if (item.quality < 50) item.quality += 1;
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        if (item.sellIn < 6) item.quality += 3;
                        else if (item.sellIn < 11) item.quality += 2;
                        else item.quality += 1;
                        break;
                    case "Conjured":
                        if (item.quality >= 2) item.quality -= 2;
                        break;
                    default:
                        if (item.quality >= 1) item.quality -= 1;
                        break;
                }
                if (item.sellIn < 0 && item.quality > 0) item.quality -= 1;
            }
        }
    }
}