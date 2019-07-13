package com.gildedrose.items;

/**
 * Created by Vusca
 */
public class CommonItem extends ItemWrapper {

    CommonItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (item.quality > 0) {
            item.quality = item.sellIn == 0 ? Math.max(0, item.quality - 2) : item.quality - 1;
        }
    }
}
