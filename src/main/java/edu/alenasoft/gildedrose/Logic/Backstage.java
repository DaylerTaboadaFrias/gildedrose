package edu.alenasoft.gildedrose.Logic;

import edu.alenasoft.gildedrose.Dto.Item;

public class Backstage implements ItemUpdateOperation{
    @Override
    public void calculateAndSaveQualityItem(Item item) {
        
        item.setQuality(item.getQuality() + 1);
        if (item.getSellIn() < 11) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
        if (item.getSellIn() < 6) {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
        if (item.getSellIn() < 0) {
            item.setQuality(item.getQuality() - item.getQuality());
        }
    }
}
