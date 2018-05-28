/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf;

/**
 *
 * @author 
 */

import cornflower.twf.model.Book;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BookList {
    public static void main(String[] args) {

	  Book starWars = new Book("978-3-16-148410-0", "Star Wars", "George R. R. Martin", "When bilbo becomes an orphan, he is recruited to hogwarts.", "Fantasy");

	  try {

		File file = new File("C:\\bookList.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(starWars, file);
		jaxbMarshaller.marshal(starWars, System.out);

	      } catch (JAXBException e) {
	      }

	}
}
