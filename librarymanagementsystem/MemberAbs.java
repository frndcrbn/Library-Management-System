package librarymanagementsystem;

import java.util.List;

public interface MemberAbs {

    String getName();
    String getID();
    List<Book> getBooksCheckOut();
    void checkOutBook(Book book);
    void returnedBook(Book book);
}
