package librarymanagementsystem;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true){
            //Menu
            System.out.println("Library Management System");
            System.out.println("[1] Add Books.");
            System.out.println("[2] Add Members.");
            System.out.println("[3] Check-out Books.");
            System.out.println("[4] Return Books.");
            System.out.println("[5] Display All Books.");
            System.out.println("[6] Display All Members.");
            System.out.println("[0] Exit Library.");
            System.out.print("Enter here: ");
            int choice = scanner.nextInt();

            switch (choice){
                // Add Books
                case 1:
                    System.out.print("Enter title:  ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter ISBN:   ");
                    String isbn = scanner.next();
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Book added.");
                    break;
                // Add Members
                case 2:
                    System.out.print("Enter name:   ");
                    String name = scanner.next();
                    System.out.print("Enter ID:     ");
                    String id = scanner.next();
                    library.addMember(new Member(name, id));
                    System.out.println("Member Added.");
                    break;
                // Check-out Books
                case 3:
                    System.out.print("Enter ISBN:       ");
                    isbn = scanner.next();
                    System.out.print("Enter member(ID): ");
                    id = scanner.next();
                    Member member = library.getMember().stream().filter(m -> m.getID().equals(id)).findFirst().orElse(null);
                    if(member != null){
                        library.checkOutBook(isbn, member);
                        System.out.println("Book Check-out.");
                    }else {
                        System.out.println("Member not found.");
                    }
                    break;
                // Returned Books
                case 4:
                    System.out.print("Enter ISBN:       ");
                    isbn = scanner.next();
                    System.out.print("Enter member(ID): ");
                    id = scanner.next();
                    member = library.getMember().stream().filter(m -> m.getID().equals(id)).findFirst().orElse(null);
                    if(member != null){
                        library.returnBook(isbn, member);
                        System.out.println("Book returned.");
                    }else{
                        System.out.println("Member not found.");
                    }
                    break;
                // Display Books
                case 5:
                    library.displayBooks();
                    break;
                // Display Members
                case 6:
                    library.displayMembers();
                    break;
                case 0:
                    System.out.println("Thank you for using us.");
                    System.exit(0);
                default:
                    System.out.println("Please select one of the options on the menu.");
                    break;
            }
        }
    }
}
