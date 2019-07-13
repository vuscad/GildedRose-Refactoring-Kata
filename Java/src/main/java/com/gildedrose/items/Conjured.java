package com.gildedrose.items;

/**
 * Created by Vusca
 */
public class Conjured extends CommonItem {

    Conjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }
}
