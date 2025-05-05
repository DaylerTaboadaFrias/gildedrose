package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;

import edu.alenasoft.gildedrose.Dto.Item;
import edu.alenasoft.gildedrose.Logic.ItemUpdate;

public class GildedRose {
  static ItemUpdate itemUpdate = new ItemUpdate();
  public static List<Item> items = new ArrayList<Item>();
  
  public static void main(String[] args) {

    System.out.println("OMGHAI!");
    items= itemUpdate.getItems();
    updateQuality();
    System.out.println(items);
  }

  public static void updateQuality() {
    itemUpdate.updateQuality(items);
  }
}
