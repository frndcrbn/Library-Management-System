package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Member implements MemberAbs{

    private String name;
    private String ID;
    private List<Book> booksCheckOut = new ArrayList<>();

    Member(String name, String ID){
        this.name = name;
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public String getID(){
        return ID;
    }

    public List<Book> getBooksCheckOut(){
        return booksCheckOut;
    }

    public void checkOutBook(Book book){
        booksCheckOut.add(book);
    }

    public void returnedBook(Book book){
        booksCheckOut.remove(book);
    }

}
