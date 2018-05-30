/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laurence Presland
 */

@XmlRootElement(name = "system")
public class TextbookSystem implements Serializable {
    private String usersFilePath;
    private String booksFilePath;
    private String reservationsFilePath;
    
    private Users users;
    private Books books;
    private Reservations reservations;
    
    /**
     * A constructor for the TextbookSystem object
     *
     */
    public TextbookSystem() {}
    
    /**
     * A constructor for the TextbookSystem object
     *
     * @param usersFilePath
     * @param booksFilePath
     * @param reservationsFilePath
     * @param users
     * @param books
     * @param reservations
     */
    public TextbookSystem(String usersFilePath, String booksFilePath, String reservationsFilePath, Users users, Books books, Reservations reservations) {
        super();
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
        this.reservationsFilePath = reservationsFilePath;
        this.users = users;
        this.books = books;
        this.reservations = reservations;
    }
    
    /**
     * A constructor for the TextbookSystem object
     *
     * @param usersFilePath - The file path of the XML file containing the users
     * @param booksFilePath - The fils path of the XML file containing the books
     * @param reservationsFilePath - The file path of the XML file containing the reservations
     */
    public TextbookSystem(String usersFilePath, String booksFilePath, String reservationsFilePath) {
        super();
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
        this.reservationsFilePath = reservationsFilePath;
    }
    
    /**
     * Get the users object
     *
     * @return
     */
    public Users getUsers() {
        return users;
    }
    
    /**
     * Get the books object
     *
     * @return
     */
    public Books getBooks() {
        return books;
    }
    
    /**
     * Get the reservations object
     *
     * @return
     */
    public Reservations getReservations() {
        return reservations;
    }
    
    /**
     * Set the users object
     *
     * @param users - The users object to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }
    
    /**
     * Set the books object
     *
     * @param books - The books object to set
     */
    public void setBooks(Books books) {
        this.books = books;
    }
    
    /**
     * Set the reservations object
     *
     * @param reservations - The reservations object to set
     */
    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }
    
    /**
     * Update the XML database with data from the models
     *
     * @throws Exception
     */
    public void updateXml() throws Exception {
        JAXBContext usersContext = JAXBContext.newInstance(Users.class);
        JAXBContext booksContext = JAXBContext.newInstance(Books.class);
        JAXBContext reservationsContext = JAXBContext.newInstance(Reservations.class);
        
        Marshaller usersMarshaller = usersContext.createMarshaller();
        Marshaller booksMarshaller = booksContext.createMarshaller();
        Marshaller reservationsMarshaller = reservationsContext.createMarshaller();
        
        usersMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        booksMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        reservationsMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        FileOutputStream usersOutputStream = new FileOutputStream(this.usersFilePath);
        FileOutputStream booksOutputStream = new FileOutputStream(this.booksFilePath);
        FileOutputStream reservationsOutputStream = new FileOutputStream(this.reservationsFilePath);
        
        usersMarshaller.marshal(this.users, usersOutputStream);
        booksMarshaller.marshal(this.books, booksOutputStream);
        reservationsMarshaller.marshal(this.reservations, reservationsOutputStream);
        
        usersOutputStream.close();
        booksOutputStream.close();
        reservationsOutputStream.close();
    }
    
    /**
     * Update the models with data from the database
     *
     * @throws Exception
     */
    public void updateFields() throws Exception {
        // Creates the unmarshallers
        JAXBContext usersContext = JAXBContext.newInstance(Users.class);
        JAXBContext booksContext = JAXBContext.newInstance(Books.class);
        JAXBContext reservationsContext = JAXBContext.newInstance(Reservations.class);
        
        Unmarshaller usersUnmarshaller = usersContext.createUnmarshaller();
        Unmarshaller booksUnmarshaller = booksContext.createUnmarshaller();
        Unmarshaller reservationsUnmarshaller = reservationsContext.createUnmarshaller();

        // Unmarshals the objects from the files
        FileInputStream usersInputStream = new FileInputStream(usersFilePath);
        FileInputStream booksInputStream = new FileInputStream(booksFilePath);
        FileInputStream reservationsInputStream = new FileInputStream(reservationsFilePath);
        
        this.users = (Users) usersUnmarshaller.unmarshal(usersInputStream);
        this.books = (Books) booksUnmarshaller.unmarshal(booksInputStream);
        this.reservations = (Reservations) reservationsUnmarshaller.unmarshal(reservationsInputStream);
        
        // Closes the input stream
        usersInputStream.close();
        booksInputStream.close();
        reservationsInputStream.close();
    }
}
