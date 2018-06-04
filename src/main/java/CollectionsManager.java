import Interface.ISell;

import java.util.ArrayList;

public class CollectionsManager {

    private ArrayList<ISell> forSaleItems;
    private ArrayList<Collection> collections;

    public CollectionsManager() {
        this.forSaleItems = new ArrayList<>();
        this.collections = new ArrayList<>();
    }

    public int countSaleItems() {
        return this.forSaleItems.size();
    }

    public int countCollections() {
        return this.collections.size();
    }

    public void addCollection(Collection collection){
        this.collections.add(collection);
    }

}
