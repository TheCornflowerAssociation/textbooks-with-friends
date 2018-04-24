/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf;

import cornflower.twf.model.Book;
import cornflower.twf.model.TextbookSystem;
import cornflower.twf.model.Lister;
import cornflower.twf.model.BookCopy;
import cornflower.twf.model.Users;
import cornflower.twf.model.Books;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Laurence Presland
 */
public class TestJAXB implements Serializable {
    public static void main(String[] args) throws Exception {
  
  BookCopy bookCopy = new BookCopy("good");
  
  Book starWars = new Book("978-3-16-148410-0", "Star Wars", "When bilbo becomes an orphan, he is recruited to hogwarts.", 5, 2015, "Fantasy", "Penguin Books", "laurencepresland@gmail.com");
  
  Books shelf = new Books();
  
  Lister laurence = new Lister("PreslandBoy", "laurencepresland@gmail.com", "corn");
  
  Users users = new Users();
  
  
  starWars.addBookCopy(bookCopy);
  shelf.AddBook(starWars);
  users.addUser(laurence);
  
  TextbookSystem system = new TextbookSystem();
  
  system.setUsers(users);
//  system.setBooks(shelf);
  
  // Boilerplate code to convert objects to XML...
  JAXBContext jc = JAXBContext.newInstance(TextbookSystem.class);
  Marshaller m = jc.createMarshaller();
  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  m.marshal(system, java.lang.System.out);
 }
}
