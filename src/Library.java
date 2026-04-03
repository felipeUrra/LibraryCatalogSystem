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

    public void removeItem(String name, Scanner scanner) {
        List<Item> coincidences = findCoincidences(name);

        if (coincidences.isEmpty()) {
            System.out.println("No item with that name.");
        } else if (coincidences.size() == 1) {
            inventory.remove(coincidences.getFirst());
        } else {
            for (int i = 0; i < coincidences.size(); i++) {
                System.out.println(i);
                coincidences.get(i).checkout();
            }

            System.out.println("Select which item you want to remove (Enter number or 'c' to cancel):");
            int input = scanner.nextInt();
            inventory.remove(coincidences.get(input));
        }
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
