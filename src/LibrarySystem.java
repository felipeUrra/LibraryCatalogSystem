import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private Library library;
    private final Scanner scanner = new Scanner(System.in);

    public LibrarySystem(Library library) {
        this.library = library;
    }

    public boolean getCommand() {
        String choice = scanner.nextLine();
        return identifyCommand(choice);
    }

    private boolean identifyCommand(String command) {
        switch (command) {
            case "add book" -> {
                askUserForBook();
                return true;
            }
            case "add paper" -> {
                askUserForPaper();
                return true;
            }
            case "remove" -> {
                String name = askUserForName();
                library.removeItem(gettingIndex(name));
                return true;
            }
            case "print all" -> {
                printAll();
                return true;
            }
            case "print all name" -> {
                String name = askUserForName();
                printAllName(name);
                return true;
            }
            case "exit" -> {
                return false;
            }
            default -> {
                System.out.println("Available commands: ....");
                return true;
            }
        }
    }

    private void askUserForBook() {
        String name = askUserForName();

        List<String> authors = askUserForAuthors();

        System.out.println("Publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // flushing leftovers

        System.out.println("Editorial: ");
        String editorial = scanner.nextLine();

        System.out.println("Edition number:");
        int editionNumber = scanner.nextInt();
        scanner.nextLine(); // flushing leftovers

        System.out.println("Path: ");
        String path = scanner.nextLine();

        Book newBook = new Book(name, authors, publicationYear, path, editorial, editionNumber);
        library.addItem(newBook);
    }

    private void askUserForPaper() {
        String name = askUserForName();

        List<String> authors = askUserForAuthors();

        System.out.println("Publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // flushing leftovers

        System.out.println("Journal name: ");
        String journalName = scanner.nextLine();

        System.out.println("Volume: ");
        int volume = scanner.nextInt();
        scanner.nextLine(); // flushing leftovers

        System.out.println("Path: ");
        String path = scanner.nextLine();

        Paper newPaper = new Paper(name, authors, publicationYear, path, journalName, volume);
        library.addItem(newPaper);
    }

    private String askUserForName() {
        System.out.println("Name: ");
        return scanner.nextLine();
    }

    private List<String> askUserForAuthors() {
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Author (or press Enter to finish): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            list.add(input);
        }

        return list;
    }

    public Library getLibrary() {
        return library;
    }

    private int gettingIndex(String name) {
        List<Item> coincidences = findCoincidences(name);

        if (coincidences.isEmpty()) {
            System.out.println("No item with that name");
            return -1;
        } else if (coincidences.size() == 1) {
            return 0;
        } else {
            for (int i = 0; i < coincidences.size(); i++) {
                System.out.println(i);
                coincidences.get(i).checkout();
            }

            System.out.println("Select the item you want to remove/update (Enter number or 'c' to cancel):");
            return scanner.nextInt();
        }
    }

    private List<Item> findCoincidences(String name) {
        List<Item> coincidences = new ArrayList<>();
        for (Item item : library.getInventory()) {
            if (item.getName().equals(name)) {
                coincidences.add(item);
            }
        }
        return coincidences;
    }

    public void printAll() {
        for (Item item : library.getInventory()) {
            item.checkout();
        }
    }

    public void printAllName(String name) {
        for (Item item : library.getInventory()) {
            if (item.getName().equals(name)) {
                item.checkout();
            }
        }
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
