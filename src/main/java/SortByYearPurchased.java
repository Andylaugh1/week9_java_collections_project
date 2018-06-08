import java.util.Comparator;

public class SortByYearPurchased implements Comparator<Item>{
    public int compare(Item a, Item b) {
        if ( a.getPurchaseYear() < b.getPurchaseYear() ) return 1;
        else if ( a.getPurchaseYear() == b.getPurchaseYear() ) return 0;
        else return -1;
    }
}
