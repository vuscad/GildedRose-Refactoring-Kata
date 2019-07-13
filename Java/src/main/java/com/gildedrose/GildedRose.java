package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.ItemWrapper;

import java.util.List;

class GildedRose {
    Item[] items;
    List<ItemWrapper> itemWrappers;

    GildedRose(Item[] items) {
        this.items = items;
        this.itemWrappers = ItemFactory.createItemWrapperList(items);
    }

    void updateQuality() {
        for (ItemWrapper itemWrapper: itemWrappers) {
            itemWrapper.update();
        }
    }
}