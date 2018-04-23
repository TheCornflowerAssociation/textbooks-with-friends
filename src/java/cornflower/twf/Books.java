/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf;

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
public class Books {
    
    @XmlElement(name="book")
    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getListers() {
        return listers;
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
}
