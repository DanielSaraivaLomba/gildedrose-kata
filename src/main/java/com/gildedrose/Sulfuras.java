package com.gildedrose;

import com.gildedrose.constants.Constants;

public class Sulfuras extends Item implements IQualityControl {

    public Sulfuras(final int sellIn, final int quality) {
        super(Constants.SULFURAS, sellIn, quality);
    }

    @Override
    public void updateItemQuality() {

    }
}
