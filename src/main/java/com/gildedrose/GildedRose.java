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

        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Conjured Mana Cake":
                updateConjured(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                updateOtherItem(item);
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        decrementSellIn(item);
        incrementQuality(item);
        if (item.sellIn < 0)
        incrementQuality(item);
    }

    private void updateBackstagePasses(Item item) {
        decrementSellIn(item);
        incrementQuality(item);

        if (item.sellIn <= 10) {
            incrementQuality(item);
        }

        if (item.sellIn <= 5) {
            incrementQuality(item);
        }
        if (item.sellIn < 0)
            item.quality -= item.quality;
    }


    private void updateConjured(Item item) {
        decrementSellIn(item);
        decrementQuality(item);
        decrementQuality(item);
    }

    private void updateOtherItem(Item item) {
        decrementSellIn(item);
        decrementQuality(item);
        if (item.sellIn < 0)
            decrementQuality(item);
    }

    private void decrementSellIn(Item item) {
        item.sellIn -= 1;
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