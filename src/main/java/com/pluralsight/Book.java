package com.pluralsight;

//Creating a Book class to represent a book in the library
public class Book {

    //Creating a Book object with the following properties: id, title, isbn, isCheckedOut, checkedOutTo
    private int id;
    private String title;
    private String isbn;
    private boolean isCheckedOut;
    private String checkedOutTo;


    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {


        return title;
    }

    public void setTitle(String title) {
        this.title = title.toUpperCase().trim();

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    //Constructors
    public Book(int id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(int id, String title, String isbn, boolean isCheckedOut) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.isCheckedOut = isCheckedOut;
    }

    //Method to check out a book
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    //Method to check in a book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }


}
