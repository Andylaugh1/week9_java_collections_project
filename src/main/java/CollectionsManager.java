import Interface.IDonate;
import Interface.ISell;

import java.util.ArrayList;

public class CollectionsManager {

    private ArrayList<ISell> forSaleItems;
    private ArrayList<IDonate> forDonationItems;
    private double profit;

    public CollectionsManager() {
        this.forSaleItems = new ArrayList<>();
        this.forDonationItems = new ArrayList<>();
        this.profit = 0;
    }

    public int countSaleItems() {
        return this.forSaleItems.size();
    }

    public int countDonationItems() {
        return this.forDonationItems.size();
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
        forSaleItems.remove(itemToSell);
        profit += extraProfit;
    }

//    public void addItemForDonation(Collection collection) {
//        for (ActionFigure item : collection.getItems()) {
//            if (ActionFigure.getDonationStatus() == true) {
//                forDonationItems.add(item);
//            }
//        }
//    }
//
//    public void donateItem(IDonate itemToDonate) {
//        forDonationItems.remove(itemToDonate);
//    }
}
