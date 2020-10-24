package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateStrategyDefault implements IUpdaterStrategy {

    @Override
    public void updateItemQuality(final Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
            if (item.sellIn < 0) {
                item.quality--;
            }
        }
    }
}

