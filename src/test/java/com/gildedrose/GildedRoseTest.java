package com.gildedrose;

import com.gildedrose.constants.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GildedRoseTest {

    GildedRose app;

    @ParameterizedTest(name = "#{index} - itemName:{0}, sellIn: {1}, quality: {2} | expectedOutput: {3}")
    @MethodSource("provideArgumentsForTest")
    void updateQuality(final String itemName, final int sellIn, final int quality, final Item expectedItem) {
        final Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
        app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertEquals(expectedItem.toString(), app.items[0].toString());
    }

    private static Stream<Arguments> provideArgumentsForTest() {
        return Stream.of(
                getTestArguments(Constants.AGED_BRIE, 30, 49, new Item(Constants.AGED_BRIE, 29, 50)),
                getTestArguments(Constants.AGED_BRIE, -1, 48, new Item(Constants.AGED_BRIE, -2, 50)),
                getTestArguments(Constants.AGED_BRIE, -1, 50, new Item(Constants.AGED_BRIE, -2, 50)),
                getTestArguments(Constants.NOT_SPECIAL, -1, 20, new Item(Constants.NOT_SPECIAL, -2, 18)),
                getTestArguments(Constants.NOT_SPECIAL, 30, 49, new Item(Constants.NOT_SPECIAL, 29, 48)),
                getTestArguments(Constants.NOT_SPECIAL, -1, 0, new Item(Constants.NOT_SPECIAL, -2, 0)),
                getTestArguments(Constants.SULFURAS, -1, 1, new Item(Constants.SULFURAS, -1, 1)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 10, 50, new Item(Constants.BACKSTAGE_PASSES, 9, 50)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 12, 49, new Item(Constants.BACKSTAGE_PASSES, 11, 50)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 10, 49, new Item(Constants.BACKSTAGE_PASSES, 9, 50)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 5, 49, new Item(Constants.BACKSTAGE_PASSES, 4, 50)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 10, 20, new Item(Constants.BACKSTAGE_PASSES, 9, 22)),
                getTestArguments(Constants.BACKSTAGE_PASSES, 5, 20, new Item(Constants.BACKSTAGE_PASSES, 4, 23)),
                getTestArguments(Constants.BACKSTAGE_PASSES, -1, 20, new Item(Constants.BACKSTAGE_PASSES, -2, 0)));
    }

    private static Arguments getTestArguments(final String itemName, final int sellIn, final int quality, final Item expectedItem) {
        return Arguments.of(itemName, sellIn, quality, expectedItem);
    }
}
