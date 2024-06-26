package com.search;



public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "123465789"));
        library.addBook(new Book("1984", "George Orwell", "987654312"));
        library.addBook(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "111214561"));
        library.addBook(new Book("Wings Of Fire", "Dr.A.P.J Abdul Kalam ", "555676788"));

        // Display all books
        System.out.println("All books in the library:");
        library.displayBooks();

        // Linear Search
        String searchTitle = "Harry Potter";
        System.out.println("\nSearching for '" + searchTitle + "' using Linear Search...");
        Book foundBook = library.linearSearch(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found");
        }

        // Binary Search
        System.out.println("\nSearching for '" + searchTitle + "' using Binary Search...");
        foundBook = library.binarySearch(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found");
        }

        // Remove a book
        Book bookToRemove = new Book("Harry Potter", "J.K. Rowling", "123465789");
        library.removeBook(bookToRemove);

        // Display all books after removal
        System.out.println("\nAll books in the library after removal:");
        library.displayBooks();
    }
}
