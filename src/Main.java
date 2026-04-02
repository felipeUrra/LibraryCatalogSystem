public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("Animal Farm", "George Orwell", 1945, "Penguin Books", 3);
        System.out.println(myBook.checkout());
    }
}