import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Item> inventory = new ArrayList<>();


    public Library() {
        inventory = null;
    }

    public Library(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(int index) {
        inventory.remove(index);
    }

    private List<Item> findCoincidences(String name) {
        List<Item> coincidences = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                coincidences.add(item);
            }
        }
        return  coincidences;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
