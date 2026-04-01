public abstract class Item {
    private String name;

    public Item() {
        name = null;
    }

    public Item(String name) {
        this.name = name;
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
}
