package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            item.updateItemQuality();
        }
    }
}
