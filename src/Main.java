public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        LibrarySystem myLibrarySystem = new LibrarySystem(myLibrary);

        System.out.println("Library Catalog System");
        myLibrarySystem.load();

        while (true) {
            if (!myLibrarySystem.getCommand()) break;
        }

        myLibrarySystem.save();
    }
}