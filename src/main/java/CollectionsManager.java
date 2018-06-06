import Interface.IDonate;

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

    public double calculateTotalPercentageProfitIfItemsSold() {
        double totalPotentialPercentageProfit = 0;
        for (Item item : forSaleItems) {
            totalPotentialPercentageProfit += (item.calculatePercentageProfitIfSold() / countSaleItems());
        }
        return totalPotentialPercentageProfit;
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

    public void donateItem(IDonate itemToDonate, Collection collection) {
        if (findItemForDonation(itemToDonate) == true) {
            forDonationItems.remove(itemToDonate);
            collection.removeItem((Item)itemToDonate);
            itemsDonated += 1;
        }
    }

    public void sortByProfit(){
        Collections.sort(forSaleItems, new SortByProfit());
    }

}
