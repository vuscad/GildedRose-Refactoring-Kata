package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.items.Item;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private final int SELL_IN_DEFAULT_VALUE = 15;
    private final int QUALITY_DEFAULT_VALUE = 15;
    private final int SULFURAS_QUALITY = 80;
    private final int SULFURAS_SELL_IN = 2;
    private final String COMMON_ITEM = "Common item";
    private final String SULFURAS = "Sulfuras";
    private final String CONJURED = "Conjured";
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES = "BackstagePasses";
    private Item[] items;

    @Before
    public void setup() {
        items = new Item[]{
            createItem(COMMON_ITEM),
            createItem(SULFURAS),
            createItem(AGED_BRIE),
            createItem(BACKSTAGE_PASSES),
            createItem(CONJURED)
        };
    }

    @Test
    public void updateQuality_oneIteration() {
        // GIVEN
        GildedRose app = new GildedRose(items);

        // WHEN
        app.updateQuality();

        // THEN
        assertEquals(COMMON_ITEM, app.itemWrappers.get(0).getName());
        assertEquals(QUALITY_DEFAULT_VALUE - 1, app.itemWrappers.get(0).getQuality());
        assertEquals(SELL_IN_DEFAULT_VALUE - 1, app.itemWrappers.get(0).getSellIn());

        assertEquals(SULFURAS, app.itemWrappers.get(1).getName());
        assertEquals(SULFURAS_QUALITY, app.items[1].quality);
        assertEquals(SULFURAS_SELL_IN, app.items[1].sellIn);

        assertEquals(AGED_BRIE, app.itemWrappers.get(2).getName());
        assertEquals(QUALITY_DEFAULT_VALUE + 1, app.itemWrappers.get(2).getQuality());
        assertEquals(SELL_IN_DEFAULT_VALUE - 1, app.itemWrappers.get(2).getSellIn());

        assertEquals(BACKSTAGE_PASSES, app.itemWrappers.get(3).getName());
        assertEquals(QUALITY_DEFAULT_VALUE + 1, app.itemWrappers.get(3).getQuality());
        assertEquals(SELL_IN_DEFAULT_VALUE - 1, app.itemWrappers.get(3).getSellIn());

        assertEquals(CONJURED, app.itemWrappers.get(4).getName());
        assertEquals(QUALITY_DEFAULT_VALUE - 2, app.itemWrappers.get(4).getQuality());
        assertEquals(SELL_IN_DEFAULT_VALUE - 1, app.itemWrappers.get(4).getSellIn());
    }

    @Test
    public void updateQuality_twentyIteration() {
        // GIVEN
        GildedRose app = new GildedRose(items);

        // WHEN
        for (int index = 0; index < 14; index ++) {
            app.updateQuality();
        }

        assertEquals(44, app.itemWrappers.get(3).getQuality());

        for (int index = 0; index < 6; index ++) {
            app.updateQuality();
        }

        // THEN
        assertEquals(COMMON_ITEM, app.itemWrappers.get(0).getName());
        assertEquals(0, app.itemWrappers.get(0).getQuality());
        assertEquals(0, app.itemWrappers.get(0).getSellIn());

        assertEquals(SULFURAS, app.itemWrappers.get(1).getName());
        assertEquals(SULFURAS_QUALITY, app.items[1].quality);
        assertEquals(SULFURAS_SELL_IN, app.items[1].sellIn);

        assertEquals(AGED_BRIE, app.itemWrappers.get(2).getName());
        assertEquals(35, app.itemWrappers.get(2).getQuality());
        assertEquals(0, app.itemWrappers.get(2).getSellIn());

        assertEquals(BACKSTAGE_PASSES, app.itemWrappers.get(3).getName());
        assertEquals(0, app.itemWrappers.get(3).getQuality());
        assertEquals(0, app.itemWrappers.get(3).getSellIn());

        assertEquals(CONJURED, app.itemWrappers.get(4).getName());
        assertEquals(0, app.itemWrappers.get(4).getQuality());
        assertEquals(0, app.itemWrappers.get(4).getSellIn());
    }

    private Item createItem(String name) {
        switch (name) {
            case SULFURAS:
                return new Item(name, SULFURAS_SELL_IN, SULFURAS_QUALITY);
            case COMMON_ITEM:
            case AGED_BRIE:
            case BACKSTAGE_PASSES:
            default:
                return new Item(name, SELL_IN_DEFAULT_VALUE, QUALITY_DEFAULT_VALUE);
        }
    }
}
