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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Book implements Serializable {
    @XmlElement(name="bookCopy")
    private ArrayList<BookCopy> bookCopies = new ArrayList<BookCopy>();
    
    // Fields
    private String isbn;
    private String title;
    private String description;
    private String author;
    private String category;

    // Constructors
    public Book() {
        super();
    }

    public Book(String isbn, String title, String author, String description, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public ArrayList<BookCopy> getBookCopies() {
        return bookCopies;
    }
    
    public ArrayList<BookCopy> getCopiesByLister(String email) {
        ArrayList<BookCopy> matchingCopies = new ArrayList<>();
        for (BookCopy copy : bookCopies) {
            if (copy.hasLister(email)) {
                matchingCopies.add(copy);
            }
        }
        return matchingCopies;
    }

    public void setBookCopies(ArrayList<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }
    
    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }
    
    public void removeBookCopy(BookCopy bookCopy) {
        bookCopies.remove(bookCopy);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public BookCopy getBookCopy(int id) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                return copy;
            }
        }
        return null;
    }
    
    public void setBookCopy(int id, BookCopy newCopy) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                copy = newCopy;
            }
        }
    }

    public boolean hasLister(String email) {
        for (BookCopy copy : bookCopies) {
            if (copy.getLister().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<BookCopy> getUnreservedCopies(Reservations reservations) {
        ArrayList<BookCopy> matchingCopies = new ArrayList<>();
        for (BookCopy copy : bookCopies) {
            if (!reservations.checkReserved(isbn, copy.getId())) {
                matchingCopies.add(copy);
            }
        }
        return matchingCopies;
    }
    
    public boolean hasUnreserved(Reservations reservations) {
        for (BookCopy copy : bookCopies) {
            if (!reservations.checkReserved(isbn, copy.getId())) {
                return true;
            }
        }
        return false;
    }
}
