package com.gildedrose;

import com.gildedrose.update.ItemUpdater;

class GildedRose {
    Item[] items;

    ItemUpdater itemUpdater = new ItemUpdater();

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            itemUpdater.updateQuality(item);
        }
    }
}
