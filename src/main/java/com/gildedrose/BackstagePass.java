package com.gildedrose;

import com.gildedrose.constants.Constants;

public class BackstagePass extends Item implements IQualityControl {

    public BackstagePass(final int sellIn, final int quality) {
        super(Constants.BACKSTAGE_PASSES, sellIn, quality);
    }
    
    @Override
    public void updateItemQuality() {
        if (quality < 50) {
            quality = quality + 1;
            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            quality = quality - quality;
        }
    }
}
