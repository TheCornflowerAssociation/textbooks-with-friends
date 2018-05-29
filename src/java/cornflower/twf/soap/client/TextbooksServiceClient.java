/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.soap.client;

/**
 *
 * @author 134991
 */
public class TextbooksServiceClient {

    public static void main(String[] args) throws IOException_Exception, Exception_Exception, JAXBException_Exception {
        TextbooksService_Service locator = new TextbooksService_Service();
        TextbooksService textbooksService = locator.getTextbooksServicePort();

        System.out.println("Listing a new book...");
        System.out.println(textbooksService.listBook("laurencepresland@gmail.com", "jeans", "978-3-16-158410-2", "Harry Potter", "A cool book about a wizard", "J.K. Rowling", "Boy Wizards", "good", 4, 2004, "Penguin Books", "laurencepresland@gmail.com"));
        System.out.println("Deleting that book...");
        System.out.println(textbooksService.deleteBook("laurencepresland@gmail.com", "jeans", "978-3-16-158410-2"));
        System.out.println("Fetching all books...");
        System.out.println(textbooksService.fetchBooks());
    }
}
