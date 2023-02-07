package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public interface LibraryAbs {

    void addBook(Book book);
    void addMember(Member member);
    List<Member> getMember();
    void checkOutBook(String ISBN, Member member);
    void returnBook(String ISBN, Member member);
    void displayBooks();
    void displayMembers();

}
