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
    
    private Users users;
    private Books books;
    
    public TextbookSystem() {}
    
    public TextbookSystem(String usersFilePath, String booksFilePath, Users users, Books books) {
        super();
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
        this.users = users;
        this.books = books;
    }
    
    public TextbookSystem(String usersFilePath, String booksFilePath) {
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
    }
    
    public Users getUsers() {
        return users;
    }
    
    public Books getBooks() {
        return books;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    public void setBooks(Books books) {
        this.books = books;
    }
    
    public void updateXml() throws Exception {
        JAXBContext usersContext = JAXBContext.newInstance(Users.class);
        JAXBContext booksContext = JAXBContext.newInstance(Books.class);
        
        Marshaller usersMarshaller = usersContext.createMarshaller();
        Marshaller booksMarshaller = booksContext.createMarshaller();
        
        usersMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        booksMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        FileOutputStream usersOutputStream = new FileOutputStream(usersFilePath);
        FileOutputStream booksOutputStream = new FileOutputStream(booksFilePath);
        
        usersMarshaller.marshal(users, usersOutputStream);
        booksMarshaller.marshal(books, booksOutputStream);
        
        usersOutputStream.close();
        booksOutputStream.close();
    }
    
    public void updateFields() throws Exception {
        // Creates the unmarshallers
        JAXBContext usersContext = JAXBContext.newInstance(Users.class);
        JAXBContext booksContext = JAXBContext.newInstance(Books.class);
        
        Unmarshaller usersUnmarshaller = usersContext.createUnmarshaller();
        Unmarshaller booksUnmarshaller = booksContext.createUnmarshaller();

        // Unmarshals the objects from the files
        FileInputStream usersInputStream = new FileInputStream(usersFilePath);
        FileInputStream booksInputStream = new FileInputStream(booksFilePath);
        
        this.users = (Users) usersUnmarshaller.unmarshal(usersInputStream);
        this.books = (Books) booksUnmarshaller.unmarshal(booksInputStream);
        
        // Closes the input stream
        usersInputStream.close();
        booksInputStream.close();
    }
}
