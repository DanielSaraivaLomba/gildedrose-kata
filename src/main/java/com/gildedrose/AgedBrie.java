package com.gildedrose;

import com.gildedrose.constants.Constants;

public class AgedBrie extends Item implements IQualityControl {

    public AgedBrie(final int sellIn, final int quality) {
        super(Constants.AGED_BRIE, sellIn, quality);
    }

    @Override
    public void updateItemQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

}
