public class Book extends Item{
    private String editorial;
    private int editionNumber;

    public Book() {
        super();
        editorial = null;
        editionNumber = 0;
    }

    public Book(String name , String authors, int publicationYear, String editorial, int editionNumber) {
        super(name, authors, publicationYear);
        this.editorial = editorial;
        this.editionNumber = editionNumber;
    }

    @Override
    public String checkout() {
        var sb = new StringBuilder("Name: ");
        sb.append(getName());
        sb.append("\n");

        sb.append("Author/s: ");
        for (String author : getAuthors()) {
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
        sb.append(getPublicationYear());
        sb.append("\n");

        return sb.toString();
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
}
