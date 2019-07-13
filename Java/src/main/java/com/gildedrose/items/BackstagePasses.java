package com.gildedrose.items;

/**
 * Created by Vusca
 */
public class BackstagePasses extends ItemWrapper {

    BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (item.sellIn == 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = Math.min(item.quality + 3, 50);
        } else if (item.sellIn <= 10) {
            item.quality = Math.min(item.quality + 2, 50);
        } else {
            item.quality++;
        }
    }
}
