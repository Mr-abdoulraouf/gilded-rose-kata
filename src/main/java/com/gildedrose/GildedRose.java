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

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                incrementQuality(item);
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality -= item.quality;
                } else {
                        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            return;
                        }
                    decrementQuality(item);
                }
            }
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);

        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else {
                if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    return;
                }
            decrementQuality(item);
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}