package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void item_quality_decreases_by_one() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void item_sellIn_decreases_by_one() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void item_quality_is_never_negative() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void aged_brie_item_quality_increases_by_one() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void aged_brie_item_quality_is_never_more_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfuras_item_quality_and_SellIn_never_changes() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void backStagePasses_item_quality_increases_by_two_when_still_10_days_in_sellIn() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void backStagePasses_item_quality_increases_by_trhee_when_sellIn_equals_5() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void conjured_item_quality_decreases_twice() {
        Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }


}
