package com.gildedrose;

public class Item implements IQualityControl {

    public String name;

    public int sellIn;

    public int quality;

    public Item(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void updateItemQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }
}
