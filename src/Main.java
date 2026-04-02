public class Main {
    public static void main(String[] args) {
        Item myItem = new Book("Animal Farm", "George Orwell", 1945, "home/Documents/AnimalFarm.pdf", "Penguin Books", 3);
        System.out.println(myItem.checkout());

        myItem = new Paper("The Lighthouse in Economics", "R.H. Coase", 1974, "/home/Documents/lighthouse.pdf", "Journal of Law and Economics", 17);
        System.out.println(myItem.checkout());
    }
}