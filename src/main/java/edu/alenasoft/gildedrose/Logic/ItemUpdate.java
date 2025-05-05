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
          if (NameItem.AGED_BRIE.equals(item.getName())) {
              itemUpdateOperation = new AgedBrie();
          } else if (NameItem.BACKSTAGE.equals(item.getName())) {
              itemUpdateOperation = new Backstage();
          } else if (NameItem.SULFURAS.equals(item.getName())) {
              itemUpdateOperation = new Sulfuras();
          } else if (NameItem.CONJURED.equals(item.getName())) {
              itemUpdateOperation = new Conjured();
          } else {
              itemUpdateOperation = new Normal();
          }
          itemUpdateOperation.calculateAndSaveQualityItem(item);
        }
    }
    
}
