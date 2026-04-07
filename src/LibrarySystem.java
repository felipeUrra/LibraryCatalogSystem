import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;

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

        int publicationYear = askForInt("Publication year: ");

        System.out.println("Editorial: ");
        String editorial = scanner.nextLine();

        int editionNumber = askForInt("Edition number");

        System.out.println("Path: ");
        String path = scanner.nextLine();

        Book newBook = new Book(name, authors, publicationYear, path, editorial, editionNumber);
        library.addItem(newBook);
    }

    private void askUserForPaper() {
        String name = askUserForName();

        List<String> authors = askUserForAuthors();

        int publicationYear = askForInt("Publication year: ");

        System.out.println("Journal name: ");
        String journalName = scanner.nextLine();

        int volume = askForInt("Volume: ");

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

    private int askForInt(String message) {
        System.out.println(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number or leave blank.");
            return 0;
        }
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
            System.out.println(item.checkout());
        }
    }

    public void printAllName(String name) {
        for (Item item : library.getInventory()) {
            if (item.getName().equals(name)) {
                System.out.println(item.checkout());
            }
        }
    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            File file = new File("library.json");
            mapper.writeValue(file, library.getInventory());
            System.out.println("Inventory saved successfully to library.json");
        } catch (IOException e) {
            System.out.println("Error saving the library" + e.getMessage());
        }
    }

    public void load() {
        File file = new File("library.json");

        if (!file.exists()) {
            System.out.println("No save file found. Starting with an empty library.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Item> loadedItems = mapper.readValue(file, new TypeReference<List<Item>>() {});
            library.setInventory(loadedItems);
            System.out.println("Loaded " + loadedItems.size() + " items from disk.");
        } catch (IOException e) {
            System.out.println("Error loading save file. Starting fresh. Error: " + e.getMessage());
        }
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
