import java.util.ArrayList;
import java.util.Collections;

public abstract class Item {
    private String name;
    private ArrayList<String> authors = new ArrayList<>();
    private int publicationYear;

    public Item() {
        name = null;
        publicationYear = 0;
    }

    public Item(String name, String authors, int publicationYear) {
        this.name = name;
        splitAuthors(authors);
        this.publicationYear = publicationYear;
    }

    public void splitAuthors(String s) {
        Collections.addAll(authors, s.split(";"));
    }

    public abstract String checkout();

    public Item returnItem() {
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
