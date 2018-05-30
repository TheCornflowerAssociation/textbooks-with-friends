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
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author J-Mo
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlSeeAlso({Books.class})
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

    /**
     * A constructor for a Book
     *
     */
    public Book() {
        super();
    }

    /**
     * A constructor for a Book
     * 
     * @param isbn - The ISBN of the book  
     * @param title - The title of the book
     * @param author - The name of the author of the book
     * @param description - A description of the book
     * @param category - The main category of the book
     */
    public Book(String isbn, String title, String author, String description, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
    }
    
    /**
     * Get a new unique ID to be used on a bookCopy
     * 
     * @return
     */
    public int getNewId() {
        int id = 1;
        while (hasCollision(id)) {
            id++;
        }
        return id;
    }
    
    /**
     * Checks if a given ID matches the ID of a stored bookCopy
     * 
     * @param id - the ID to check
     * @return 
     */
    private boolean hasCollision(int id) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                    return true;
            }
        }
        return false;
    }

    /**
     * Get a list of bookCopy objects
     * 
     * @return
     */
    public ArrayList<BookCopy> getBookCopies() {
        return bookCopies;
    }
    
    /**
     * Get the number of stored bookCopies
     * 
     * @return
     */
    public int getBookCopiesAmount() {
        return bookCopies.size();
    }
    
    /**
     * Get a list of bookCopy objects which were listed by a given user.
     * 
     * @param email - The email of the user
     * @return
     */
    public ArrayList<BookCopy> getCopiesByLister(String email) {
        ArrayList<BookCopy> matchingCopies = new ArrayList<>();
        for (BookCopy copy : bookCopies) {
            if (copy.hasLister(email)) {
                matchingCopies.add(copy);
            }
        }
        return matchingCopies;
    }

    /**
     * Set the list of stored bookCopy objects
     * 
     * @param bookCopies - The list of bookCopy objects
     */
    public void setBookCopies(ArrayList<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }
    
    /**
     * Add a bookCopy to the list of stored bookCopy objects
     *
     * @param bookCopy - The bookCopy to add
     */
    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }
    
    /**
     * Remove a bookCopy from the list of stored bookCopy objects
     *
     * @param bookCopy - The bookCopy to remove
     */
    public void removeBookCopy(BookCopy bookCopy) {
        bookCopies.remove(bookCopy);
    }

    /**
     * Get the ISBN of the book
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set the ISBN of the book
     *
     * @param isbn - The ISBN of the book
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the title of the book
     *
     * @return
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Get the author of the book
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the title of the book
     *
     * @param title - The title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the description of the book
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the book
     *
     * @param description - The description of the book
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the category of the book
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the book
     *
     * @param category - The category of the book
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * Get the bookCopy with the given ID
     *
     * @param id - The ID of the bookCopy
     * @return
     */
    public BookCopy getBookCopy(int id) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                return copy;
            }
        }
        return null;
    }
    
    /**
     * Set the bookCopy object with a specific ID
     *
     * @param id - The ID of the bookCopy
     * @param newCopy - The new bookCopy
     */
    public void setBookCopy(int id, BookCopy newCopy) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                copy = newCopy;
            }
        }
    }

    /**
     * Check if the lister of the book matches a given email address
     *
     * @param email - The email of the lister to check
     * @return
     */
    public boolean hasLister(String email) {
        for (BookCopy copy : bookCopies) {
            if (copy.getLister().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get a list of bookCopy objects which are unreserved
     *
     * @param reservations - The reservations object
     * @return
     */
    public ArrayList<BookCopy> getUnreservedCopies(Reservations reservations) {
        ArrayList<BookCopy> matchingCopies = new ArrayList<>();
        for (BookCopy copy : bookCopies) {
            if (!reservations.checkReserved(isbn, copy.getId())) {
                matchingCopies.add(copy);
            }
        }
        return matchingCopies;
    }
    
    /**
     * Checks if there are any unreserved book copies
     *
     * @param reservations - The reservations object
     * @return
     */
    public boolean hasUnreserved(Reservations reservations) {
        for (BookCopy copy : bookCopies) {
            if (!reservations.checkReserved(isbn, copy.getId())) {
                return true;
            }
        }
        return false;
    }
}
