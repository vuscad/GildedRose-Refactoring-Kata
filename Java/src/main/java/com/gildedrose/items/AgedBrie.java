package com.gildedrose.items;

/**
 * Created by Vusca
 */
public class AgedBrie extends ItemWrapper {

    AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (item.quality < 50) item.quality++;
    }
}
