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
        updateItemQuality(item);

        updateItemSellIn(item);
    }

    private void updateItemSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            item.sellIn -= 1;
        }

        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
            case "Aged Brie":
                if (item.sellIn < 0)
                incrementQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn < 0)
                item.quality -= item.quality;
                break;
            default:
                if (item.sellIn < 0)
                decrementQuality(item);
                break;
        }
    }



    private void updateItemQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                incrementQuality(item);

                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                incrementQuality(item);

                if (item.sellIn < 11) {
                    incrementQuality(item);
                }

                if (item.sellIn < 6) {
                    incrementQuality(item);
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:

                decrementQuality(item);
                break;
        }
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