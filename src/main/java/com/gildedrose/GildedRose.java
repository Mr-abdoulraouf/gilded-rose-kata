package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
            item.sellIn -= 1;
        }
        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                incrementQuality(item);

                if (item.sellIn < 11) {
                    incrementQuality(item);
                }

                if (item.sellIn < 6) {
                    incrementQuality(item);
                }
                if (item.sellIn < 0)
                item.quality -= item.quality;
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                decrementQuality(item);
                if (item.sellIn < 0)
                decrementQuality(item);
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        incrementQuality(item);
        if (item.sellIn < 0)
        incrementQuality(item);
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}