/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf;

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
public class System implements Serializable {
    private String usersFilePath;
    private String booksFilePath;
    
    private Users users;
    private Books books;
    
    public System() {}
    
    public System(String usersFilePath, String booksFilePath, Users users, Books books) {
        super();
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
        this.users = users;
        this.books = books;
    }
    
    public void setFilePath(String usersFilePath, String booksFilePath) throws Exception {
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
    
    public void updateXML(Users users, Books books, String usersFilePath, String booksFilePath) throws Exception {
        this.users = users;
        this.books = books;
        this.usersFilePath = usersFilePath;
        this.booksFilePath = booksFilePath;
        
        saveUsers();
        saveBooks();
    }
    
    public void saveUsers() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(usersFilePath);
        m.marshal(users, fout);
        fout.close();
    }
    
    public void saveBooks() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Books.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(booksFilePath);
        m.marshal(users, fout);
        fout.close();
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
}
