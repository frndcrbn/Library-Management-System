package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryAbs{

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public List<Member> getMember(){
        return members;
    }

    public void checkOutBook(String ISBN, Member member) {
        Book bookToCheckOut = null;
        for (Book book : books){
            if (book.getISBN().equals(ISBN) && book.isAvailable()){
                bookToCheckOut = book;
                break;
            }
        }
        if (bookToCheckOut != null){
            member.checkOutBook(bookToCheckOut);
            bookToCheckOut.setAvailability(false);
        }else{
            System.out.println("This Book is not available.");
        }
    }

    public void returnBook(String ISBN, Member member) {
        Book bookToReturn = null;
        for (Book book : member.getBooksCheckOut()){
            if(book.getISBN().equals(ISBN)){
                bookToReturn = book;
                break;
            }
        }
        if (bookToReturn != null){
            member.returnedBook(bookToReturn);
            bookToReturn.setAvailability(true);
        }else{
            System.out.println("Book not found in member's checked out books");
        }
    }

    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("Books are Empty.");
        }else {
            System.out.println("Books: ");
            for (Book book : books){
                System.out.println("Title:      " + book.getTitle());
                System.out.println("Author:     " + book.getAuthor());
                System.out.println("ISBN:       " + book.getISBN());
                System.out.println("Available:  " + book.isAvailable());
            }
        }

    }

    public void displayMembers(){
        if (members.isEmpty()){
            System.out.println("Members are Empty.");
        }else{
            System.out.println("Members: ");
            for (Member member : members){
                System.out.println("Name:   " + member.getName());
                System.out.println("ID:     " + member.getID());
            }
        }
    }
}
