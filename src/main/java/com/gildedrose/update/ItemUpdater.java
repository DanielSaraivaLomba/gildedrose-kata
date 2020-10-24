package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.constants.Constants;

import java.util.HashMap;

public class ItemUpdater {

    HashMap<String, IUpdaterStrategy> updaterStrategyResolver;

    public ItemUpdater() {
        this.updaterStrategyResolver = new HashMap<>() {{
            put(Constants.AGED_BRIE, new UpdateStrategyAgedBrie());
            put(Constants.BACKSTAGE_PASSES, new UpdateStrategyBackstagePasses());
            put(Constants.SULFURAS, new UpdateStrategyNull());
            put(Constants.DEFAULT, new UpdateStrategyDefault());
            put(Constants.CONJURED, new UpdateStrategyDoubleDecrease());
        }};
    }

    public void updateQuality(final Item item) {
        switch (item.name) {
            case Constants.AGED_BRIE:
                updaterStrategyResolver.get(Constants.AGED_BRIE).updateItemQuality(item);
                break;
            case Constants.BACKSTAGE_PASSES:
                updaterStrategyResolver.get(Constants.BACKSTAGE_PASSES).updateItemQuality(item);
                break;
            case Constants.SULFURAS:
                updaterStrategyResolver.get(Constants.SULFURAS).updateItemQuality(item);
                break;
            case Constants.CONJURED:
                updaterStrategyResolver.get(Constants.CONJURED).updateItemQuality(item);
                break;
            default:
                updaterStrategyResolver.get(Constants.DEFAULT).updateItemQuality(item);
                break;
        }
    }
}

