package com.gildedrose.items;

/**
 * Created by Vusca
 */
public abstract class ItemWrapper {
    protected Item item;

    ItemWrapper(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.name;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void update() {
        if (item.sellIn > 0) updateSellIn();
        updateQuality();
    }

    abstract protected void updateQuality();

    protected void updateSellIn(){
        item.sellIn--;
    }
}
