package edu.alenasoft.gildedrose.Logic;

import edu.alenasoft.gildedrose.Dto.Item;

public class Conjured implements ItemUpdateOperation{

    @Override
    public void calculateAndSaveQualityItem(Item item) {
        if(! (item.getQuality() <= 0)){
            if(! (item.getQuality() == 1)){
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() - 2);
                }
                if (item.getSellIn() < 0) {
                    item.setQuality(item.getQuality() - 2);
                    if (item.getQuality() < 0) {
                        item.setQuality(0);
                    }
                }
            }else{
                item.setQuality(0);
            }
        }
    }
    
}
