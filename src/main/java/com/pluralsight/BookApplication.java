package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApplication {

    //Creating a static arraylist to store books
    //Declaring all my reusable variables at the top of the class
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner userInput = new Scanner(System.in);
    static int userChoice;

    public static void main(String[] args) {

        //Calling the booksInTheLibrary method to populate the book arraylist with some initial data
        booksInTheLibrary();

        //Creating a loop to keep the application running until the user chooses to exit
        do {

            //calling the mainMenu method to display the main menu
            mainMenu();

            System.out.print("Enter your choice: ");
            userChoice = userInput.nextInt();
            userInput.nextLine();
            switch (userChoice) {
                case 1 -> displayAllBooks();
                case 2 -> checkOutBook();
                case 3 -> returnBook();
                case 4 -> addBook();
                case 5 -> System.out.println("Exiting the application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 5);
    }

    //Method to display all books in the library
    public static void displayAllBooks() {

        //Checking if the book arraylist is empty before displaying the books
        if (books.isEmpty()) {
            System.out.println("\nThe library is empty!");
            return;
        }

        //Displaying the books in the library with a formatted output
        System.out.println("\nBooks in the Library:");
        System.out.printf("%-5s %-30s %-22s %-20s\n", "ID", "Title", "ISBN", "Status");
        for (Book book : books) {
            String status = book.isCheckedOut() ? "Checked out to: " + book.getCheckedOutTo() : "Available";
            System.out.printf("%-5s %-30s %-22s %-20s\n", book.getId(), book.getTitle(), book.getIsbn(), status);
        }
    }

    //Displaying the main menu
    public static void mainMenu() {
        System.out.println("""
                
                     **************
                Welcome to the Book Library!
                     **************
                
                Please select an option:
                1. Display all books
                2. Check out a book
                3. Return a book
                4. Add a book
                5. Exit
                """);
    }

    //Adding books to the library
    //Populated method to add books to the library
    public static void booksInTheLibrary() {
        books.add(new Book(1, "Java in Action", "978-1-7891-3947-2"));
        books.add(new Book(2, "Java EE 8", "978-1-7891-3948-9"));
        books.add(new Book(3, "Java EE 7", "978-1-7891-3949-6"));
        books.add(new Book(4, "Java EE 6", "978-1-7891-3950-3"));
        books.add(new Book(5, "Java EE 5", "978-1-7891-3951-0"));
        books.add(new Book(6, "Java EE 4", "978-1-7891-3952-7"));
        books.add(new Book(7, "Java EE 3", "978-1-7891-3953-4"));
        books.add(new Book(8, "Java EE 2", "978-1-7891-3954-1"));
        books.add(new Book(9, "Java EE 1", "978-1-7891-3955-8"));
        books.add(new Book(10, "Java EE 10", "978-1-7891-3956-5"));
    }

    //Checking out a book
    public static void checkOutBook() {

        System.out.print("Enter the ID of the book you want to check out: ");
        int bookId = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter your name: ");
        String name = userInput.nextLine().trim();

        // Validate name isn't empty
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        // Check if the book exists and is available
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isCheckedOut()) {
                    book.checkOut(name);
                    System.out.println("You have checked out: " + book.getTitle());
                } else {
                    System.out.println("Sorry, " + book.getTitle() + " is already checked out to " + book.getCheckedOutTo());
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    //Returning a book
    public static void returnBook() {

        System.out.print("Enter the ID of the book you want to return: ");
        int bookId = userInput.nextInt();
        userInput.nextLine();

        // Check if the book exists and is checked out
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("You have returned: " + book.getTitle());
                } else {
                    System.out.println("Sorry, " + book.getTitle() + " is not checked out.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    //Adding a book to the library
    public static void addBook() {  // No parameter needed

        int nextId = getNextId();

        System.out.print("Enter the title of the new book: ");
        String title = userInput.nextLine();

        System.out.print("Enter the ISBN of the new book: ");
        String isbn = userInput.nextLine();

        books.add(new Book(nextId, title, isbn));
        System.out.println("Book added successfully!");
    }

    //Method to get the next available ID for a new book
    public static int getNextId() {
        int maxId = 0;
        for (Book book : books) {
            if (book.getId() > maxId) {
                maxId = book.getId();
            }
        }
        return maxId + 1;
    }

}
