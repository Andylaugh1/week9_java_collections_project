import Interface.ISell;

import java.util.ArrayList;

public class CollectionsManager {

    private ArrayList<ISell> forSaleItems;

    public CollectionsManager() {
        this.forSaleItems = new ArrayList<>();
    }

    public int countSaleItems() {
        return this.forSaleItems.size();
    }

   public void addSaleItem(ISell item) {
        forSaleItems.add(item);
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
}
