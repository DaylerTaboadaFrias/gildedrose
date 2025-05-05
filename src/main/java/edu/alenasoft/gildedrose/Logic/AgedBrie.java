package edu.alenasoft.gildedrose.Logic;

import edu.alenasoft.gildedrose.Dto.Item;

public class AgedBrie implements ItemUpdateOperation{

	@Override
	public void calculateAndSaveQualityItem(Item item) {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
		if (item.getSellIn() < 0) {
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}
		}
	}
}
