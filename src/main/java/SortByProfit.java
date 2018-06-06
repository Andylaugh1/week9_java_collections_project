import java.util.Comparator;

public class SortByProfit implements Comparator<Item> {
    public int compare(Item a, Item b) {
        if ( a.calculateProfitIfSold() < b.calculateProfitIfSold() ) return 1;
        else if ( a.calculateProfitIfSold() == b.calculateProfitIfSold() ) return 0;
        else return -1;
    }

}
