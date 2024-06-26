package com.search; 
 
import java.util.Objects; 
 
public class Book implements Comparable<Book> { 
    private String title; 
    private String author; 
    private String ISBN; 
 
    // Constructor 
    public Book(String title, String author, String ISBN) { 
        this.title = title; 
        this.author = author; 
        this.ISBN = ISBN; 
    } 
 
    // Getters and Setters 
    public String getTitle() { 
        return title; 
    } 
 
    public void setTitle(String title) { 
        this.title = title; 
    } 
 
    public String getAuthor() { 
        return author; 
    } 
 
    public void setAuthor(String author) { 
        this.author = author; 
    } 
 
    public String getISBN() { 
        return ISBN; 
    } 
 
    public void setISBN(String ISBN) { 
        this.ISBN = ISBN; 
    } 
 
    // compareTo method for sorting by title 
    @Override 
    public int compareTo(Book other) { 
        return this.title.compareTo(other.title); 
    } 
 
    // toString method for displaying book information 
    @Override 
    public String toString() { 
        return "Book{" + 
                "title='" + title + '\'' + 
                ", author='" + author + '\'' + 
                ", ISBN='" + ISBN + '\'' + 
                '}'; 
    } 
 
    // Override equals and hashCode methods 
    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Book book = (Book) o; 
        return Objects.equals(title, book.title) && 
                Objects.equals(author, book.author) && 
                Objects.equals(ISBN, book.ISBN); 
    } 
 
    @Override 
    public int hashCode() { 
        return Objects.hash(title, author, ISBN); 
    } 
}