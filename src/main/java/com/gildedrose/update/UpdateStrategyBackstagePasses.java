package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateStrategyBackstagePasses implements IUpdaterStrategy {
    
    @Override
    public void updateItemQuality(final Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }
    }
}
