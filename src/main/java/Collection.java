import enums.CollectionType;
import enums.DrinkType;

import java.util.ArrayList;

public class Collection {

    private CollectionType collectionType;
    private ArrayList<Item> items;


    public Collection(CollectionType collectionType) {
        this.collectionType = collectionType;
        this.items = new ArrayList<>();
    }


    public CollectionType getCollectionType() {
        return collectionType;
    }

    public int countItems() {
        return this.items.size();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public double calculateTotalItemPricePaid() {
        double totalPricePaid = 0;
        for (Item item : items) {
            totalPricePaid += item.getBuyPrice();
        }
        return totalPricePaid;
    }

    public double calculateTotalShippingPricePaid() {
        double totalShippingPrice = 0;
        for (Item item : items) {
            totalShippingPrice += item.getShippingPrice();
        }
        return totalShippingPrice;
    }

    public double calculateTotalPricePaid() {
        double totalPricePaid = calculateTotalItemPricePaid() + calculateTotalShippingPricePaid();
        return totalPricePaid;
    }

    public ArrayList<Item> getItemsMarkedForReSale() {
        ArrayList itemsForSale = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getResaleStatus() == true) {
                itemsForSale.add(item);
            }
        }
        return itemsForSale;
    }
}
