import Interface.ISell;

import java.util.ArrayList;

public class CollectionsManager {

    private ArrayList<ISell> forSaleItems;
    private double profit;

    public CollectionsManager() {
        this.forSaleItems = new ArrayList<>();
        this.profit = 0;
    }

    public int countSaleItems() {
        return this.forSaleItems.size();
    }

   public void addSaleItem(ISell item) {
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
        for (ISell item : forSaleItems) {
            totalPotentialProfit += item.calculateProfitIfSold();
        }
        return totalPotentialProfit;
    }

    public void sellItem(ISell itemToSell) {
        double extraProfit = itemToSell.calculateProfitIfSold();
        for (ISell i : forSaleItems) {
            if (i == itemToSell) {
                forSaleItems.remove(i);
            }
        }
        profit += extraProfit;

    }
}
