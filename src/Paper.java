public class Paper extends Item{
    private String journalName;
    private float volume;

    public Paper() {
        super();
        journalName = null;
        volume = 0;
    }

    public Paper(String name , String authors, int publicationYear, String journalName, float volume) {
        super(name, authors, publicationYear);
        this.journalName = journalName;
        this.volume = volume;
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
        sb.append("Journal name: ");
        sb.append(journalName);
        sb.append("\n");
        sb.append("Volume: ");
        sb.append(volume);
        sb.append("\n");
        sb.append("Publication year: ");
        sb.append(getPublicationYear());
        sb.append("\n");

        return sb.toString();
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
