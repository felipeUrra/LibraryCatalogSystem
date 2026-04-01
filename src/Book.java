import java.util.ArrayList;
import java.util.Collections;


public class Book extends Item{
    private ArrayList<String> authors = new ArrayList<>();
    private String editorial;
    private int editionNumber;
    private int publicationYear;

    public Book() {
        super();
        editorial = null;
        editionNumber = 0;
        publicationYear = 0;
    }

    public Book(String name , String authors, String editorial, int editionNumber, int publicationYear) {
        super(name);
        splitAuthors(authors);
        this.editorial = editorial;
        this.editionNumber = editionNumber;
        this.publicationYear = publicationYear;
    }

    @Override
    public String checkout() {
        var sb = new StringBuilder("Name: ");
        sb.append(getName());
        sb.append("\n");

        sb.append("Author/s: ");
        for (String author : authors) {
            sb.append(author);
            sb.append("\n");
        }
        sb.append("Editorial: ");
        sb.append(editorial);
        sb.append("\n");
        sb.append("Edition number: ");
        sb.append(editionNumber);
        sb.append("\n");
        sb.append("Publication year: ");
        sb.append(publicationYear);
        sb.append("\n");

        return sb.toString();
    }

    public void splitAuthors(String s) {
        Collections.addAll(authors, s.split(";"));
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
