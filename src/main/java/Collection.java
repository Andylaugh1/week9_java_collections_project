import java.util.ArrayList;

public class Collection {

    private String name;
    private ArrayList<Item> items;


    public Collection(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }


    public String getName() {
        return name;
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
}
