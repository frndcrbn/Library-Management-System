package librarymanagementsystem;

public interface BookAbs {

    String getTitle();
    String getAuthor();
    String getISBN();
    boolean isAvailable();
    void setAvailability(boolean availability);
}
