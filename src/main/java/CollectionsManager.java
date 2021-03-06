import Interface.IDonate;
import Interface.ISwap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionsManager {

    private ArrayList<Item> forSaleItems;
    private ArrayList<IDonate> forDonationItems;
    private double profit;
    private int itemsDonated;

    public CollectionsManager() {
        this.forSaleItems = new ArrayList<>();
        this.forDonationItems = new ArrayList<>();
        this.profit = 0;
        this.itemsDonated = 0;
    }

    public int getItemsDonated() {
        return this.itemsDonated;
    }

    public ArrayList getForSaleItems(){
        return forSaleItems;
    }

    public int countSaleItems() {
        return this.forSaleItems.size();
    }

    public int countDonationItems() {
        return this.forDonationItems.size();
    }

   public void addSaleItem(Item item) {
        forSaleItems.add(item);
   }

   public double getProfit() {
        return profit;
   }

   public void addSellableItemsFromCollection(Collection collection) {
        for (Item item : collection.getItems()) {
            if (item.getResaleStatus() == true) {
                forSaleItems.add(item);
            }
        }
   }

    public double calculateProfitIfSold() {
        double totalPotentialProfit = 0;
        for (Item item : forSaleItems) {
            totalPotentialProfit += item.calculateProfitIfSold();
        }
        return totalPotentialProfit;
    }

    public double calculateAveragePercentageProfitIfItemsSold() {
        double averagePotentialPercentageProfit = 0;
        for (Item item : forSaleItems) {
            averagePotentialPercentageProfit += (item.calculatePercentageProfitIfSold() / countSaleItems());
        }
        return averagePotentialPercentageProfit;
    }

    public void sellItem(Item itemToSell, Collection collection) {
        double extraProfit = itemToSell.calculateProfitIfSold();
        forSaleItems.remove(itemToSell);
        collection.removeItem(itemToSell);
        profit += extraProfit;
    }

    public void addItemForDonation(IDonate item) {
        forDonationItems.add(item);
    }

    public boolean findItemForDonation(IDonate item) {
        return forDonationItems.contains(item);
    }

    public void donateItem(IDonate itemToDonate, Collection collection, String destination) {
        if (findItemForDonation(itemToDonate) == true) {
            forDonationItems.remove(itemToDonate);
            collection.removeItem((Item)itemToDonate);
            itemsDonated += 1;
            System.out.println(itemToDonate + " has been donated to " + destination);
        }
        else System.out.println(itemToDonate + " has not been donated as it is not in your donation list");
    }

    public void sortByProfit(){
        Collections.sort(forSaleItems, new SortByProfit());
    }

    public void sortByPurchaseYear() {
        Collections.sort(forSaleItems, new SortByYearPurchased());
    }

    public void swapItem(Collection collection, Item oldItem, Item newItem) {
        collection.removeItem(oldItem);
        collection.addItem(newItem);
    }

    public void addManyItemsToDonationList(ArrayList<IDonate> items) {
        for (IDonate item : items) {
            forDonationItems.add(item);
        }
    }

    public void donateManyItemsAtOnce(ArrayList<IDonate> items, String destination) {
        for (IDonate item : items) {
            if (findItemForDonation(item) == true) {
                forDonationItems.remove(item);
                itemsDonated +=1;
                System.out.println(item + " has been donated to " + destination);
            }
            else System.out.println("Sorry, not all items were donated as " + item + " is not in your donation list");
        }
    }
}
