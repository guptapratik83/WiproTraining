package com.search;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library and sort the list
    public void addBook(Book book) {
        books.add(book);
        Collections.sort(books);
    }

    // Remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Linear Search for a book by title
    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search for a book by title
    public Book binarySearch(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
