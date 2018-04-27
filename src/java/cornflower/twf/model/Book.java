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
    
    @XmlElement(name = "isbn")
    private String isbn;
    
    @XmlElement(name = "title")
    private String title;
    
    @XmlElement(name = "description")
    private String description;
    
    @XmlElement(name = "edition")
    private Integer edition;
    
    @XmlElement(name = "year")
    private Integer year;
    
    @XmlElement(name = "category")
    private String category;
    
    @XmlElement(name = "publisher")
    private String publisher;
    
    @XmlElement(name = "lister")
    private String lister;
    
    @XmlElement(name = "author")
    private String author;

    // Constructors
    public Book() {
        super();
    }

    public Book(String isbn, String title, String author, String description, Integer edition, Integer year, String category, String publisher, String lister) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.edition = edition;
        this.year = year;
        this.category = category;
        this.publisher = publisher;
        this.lister = lister;
    }

    public ArrayList<BookCopy> getBookCopies() {
        return bookCopies;
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

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLister() {
        return lister;
    }

    public void setLister(String lister) {
        this.lister = lister;
    }
    
    public BookCopy getBookCopy(int id) {
        for (BookCopy copy : bookCopies) {
            if (copy.getId() == id) {
                return copy;
            }
        }
        return null;
    }
    
}
