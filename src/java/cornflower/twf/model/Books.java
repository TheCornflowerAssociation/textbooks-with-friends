/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author J-Mo
 */

@XmlRootElement(name="books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books implements Serializable {
    
    @XmlElement(name="book")
    private ArrayList<Book> books = new ArrayList<Book>();
    
    /**
     * A constructor for the Books object
     *
     */
    public Books() {
        super();
    }
    
    /**
     * A constructor for the Books object
     *
     * @param books - The list of Books
     */
    public Books(ArrayList<Book> books) {
        this.books = books;
    }
    
    /**
     * Get a Book with a specific ISBN
     *
     * @param isbn - The ISBN of the Book
     * @return
     */
    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Remove a specific book
     *
     * @param book - The Book to remove
     */
    public void removeBook(Book book) {
        books.remove(book);
    }
    
    /**
     * Set the Book with a given ISBN
     *
     * @param isbn - The ISBN of the new Book
     * @param newBook - The new Book to set
     */
    public void setBook(String isbn, Book newBook) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book = newBook;
            }
        }
    }
    
    /**
     * Get a list of Books with a specific lister
     *
     * @param email - The email of the lister
     * @return
     */
    public ArrayList<Book> getBooksByLister(String email) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.hasLister(email)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
    
    /**
     * Get a list of Books which have unreserved bookCopys
     *
     * @param reservations - The reservations object
     * @return
     */
    public ArrayList<Book> getUnreservedBooks(Reservations reservations) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.hasUnreserved(reservations)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    /**
     * Set the list of Books
     *
     * @param books - The Books object to add
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Get the list of Books
     *
     * @return
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Add a Book to the list of Books
     *
     * @param book - The book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }
    
}
