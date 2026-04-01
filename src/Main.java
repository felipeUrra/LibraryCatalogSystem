public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("Animal Farm", "George Orwell", "Penguin Books", 3, 1945);
        System.out.println(myBook.checkout());
    }
}