import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "book"),
        @JsonSubTypes.Type(value = Paper.class, name = "paper")
})

public abstract class Item {
    private String name;
    private List<String> authors = new ArrayList<>();
    private int publicationYear;
    private String path;

    public Item() {
        name = null;
        publicationYear = 0;
        path = null;
    }

    public Item(String name, List<String> authors, int publicationYear, String path) {
        this.name = name;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.path = path;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
