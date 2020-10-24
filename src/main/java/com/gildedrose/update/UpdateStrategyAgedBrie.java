package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateStrategyAgedBrie implements IUpdaterStrategy {

    @Override
    public void updateItemQuality(final Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 0) {
                item.quality++;
            }
        }
    }

}
