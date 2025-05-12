package edu.alenasoft.gildedrose.Logic;

import java.util.ArrayList;
import java.util.List;

import edu.alenasoft.gildedrose.Dto.Item;
import edu.alenasoft.gildedrose.Utils.NameItem;

public class ItemUpdate {
    
    private List<Item> items ;

    private ItemUpdateOperation itemUpdateOperation ;

    public ItemUpdate() {
      items = new ArrayList<>();
      initializeItems();
    }
    
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void getItem(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println(items.get(index));
        } else {
            System.out.println("Index out of bounds");
        }
    }
    
    public void initializeItems() {
        items.add(new Item(NameItem.AGED_BRIE, 2, 0));
        items.add(new Item(NameItem.BACKSTAGE, 15, 20));
        items.add(new Item(NameItem.DEXTERITY,10, 20));
        items.add(new Item(NameItem.ELIXIR, 5, 7));
        items.add(new Item(NameItem.SULFURAS, 0, 80));
        items.add(new Item(NameItem.CONJURED, 3, 6));
    }

    public void updateQuality(List<Item> items) {
        for (Item item : items) {
            item.setSellIn(item.getSellIn() - 1);
            switch (item.getName()) {
                case NameItem.AGED_BRIE:
                    itemUpdateOperation = new AgedBrie();
                    itemUpdateOperation.calculateAndSaveQualityItem(item);
                    break;
                case NameItem.BACKSTAGE:
                    itemUpdateOperation = new Backstage();
                    itemUpdateOperation.calculateAndSaveQualityItem(item);
                    break;
                case NameItem.CONJURED:
                    itemUpdateOperation = new Conjured();
                    itemUpdateOperation.calculateAndSaveQualityItem(item);
                    break;
                case NameItem.SULFURAS:
                    break;
                default:
                    itemUpdateOperation = new Normal();
                    itemUpdateOperation.calculateAndSaveQualityItem(item);
                    break;
            }
        }
    }
    
}
