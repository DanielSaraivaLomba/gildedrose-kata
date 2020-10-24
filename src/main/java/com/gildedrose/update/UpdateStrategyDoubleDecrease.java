package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateStrategyDoubleDecrease implements IUpdaterStrategy {
    @Override
    public void updateItemQuality(final Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.sellIn < 0) {
                item.quality -= 2;
            }
        }
    }
}
