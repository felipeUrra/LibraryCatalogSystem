import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private Library library;
    private final Scanner scanner = new Scanner(System.in);

    public LibrarySystem(Library library) {
        this.library = library;
    }

    public void start() {
        System.out.println("Library Catalog System");
        String choice = scanner.nextLine();
        identifyCommand(choice);
    }

    private void identifyCommand(String command) {
        switch (command) {
            case "add book" -> askUserForBook();
            case "add paper" -> askUserForPaper();
            case "remove" -> {
                String name = askUserForName();
                library.removeItem(name, scanner);
            }
        }
    }

    private void askUserForBook() {
        String name = askUserForName();

        List<String> authors = askUserForAuthors();

        System.out.println("Publication year: ");
        int publicationYear = scanner.nextInt();

        System.out.println("Editorial: ");
        String editorial = scanner.nextLine();

        System.out.println("Edition number:");
        int editionNumber = scanner.nextInt();

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

        System.out.println("Journal name: ");
        String journalName = scanner.nextLine();

        System.out.println("Volume: ");
        int volume = scanner.nextInt();

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

    public void setLibrary(Library library) {
        this.library = library;
    }
}
