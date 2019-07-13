package com.gildedrose.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vusca
 */
public class ItemFactory {

    public static ItemWrapper createItemWrapper(Item item) {
        checkInitialvalues(item);

        switch (item.name){
            case "Sulfuras": return new Sulfuras(item);
            case "Conjured": return new Conjured(item);
            case "Aged Brie": return new AgedBrie(item);
            case "BackstagePasses": return new BackstagePasses(item);
            default: return new CommonItem(item);
        }
    }

    public static List<ItemWrapper> createItemWrapperList(Item[] items) {
        List<ItemWrapper> itemWrappers = new ArrayList<>();
        for (Item item : items) {
            itemWrappers.add(createItemWrapper(item));
        }

        return itemWrappers;
    }

    private static void checkInitialvalues(Item item) {
        if (!item.name.equals("Sulfuras")) {
            if (item.quality < 0) item.quality = 0;
            if (item.quality > 50) item.quality = 50;
        }
        item.sellIn = Math.max(0, item.sellIn);
    }
}
