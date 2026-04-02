import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> inventory = new ArrayList<>();


    public Library() {
    }

    public Library(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
