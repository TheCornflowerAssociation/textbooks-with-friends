
package cornflower.twf.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cornflower.twf.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://soap.twf.cornflower/", "Exception");
    private final static QName _IOException_QNAME = new QName("http://soap.twf.cornflower/", "IOException");
    private final static QName _JAXBException_QNAME = new QName("http://soap.twf.cornflower/", "JAXBException");
    private final static QName _Book_QNAME = new QName("http://soap.twf.cornflower/", "book");
    private final static QName _BookCopy_QNAME = new QName("http://soap.twf.cornflower/", "bookCopy");
    private final static QName _Books_QNAME = new QName("http://soap.twf.cornflower/", "books");
    private final static QName _DeleteBook_QNAME = new QName("http://soap.twf.cornflower/", "deleteBook");
    private final static QName _DeleteBookResponse_QNAME = new QName("http://soap.twf.cornflower/", "deleteBookResponse");
    private final static QName _FetchBooks_QNAME = new QName("http://soap.twf.cornflower/", "fetchBooks");
    private final static QName _FetchBooksResponse_QNAME = new QName("http://soap.twf.cornflower/", "fetchBooksResponse");
    private final static QName _ListBook_QNAME = new QName("http://soap.twf.cornflower/", "listBook");
    private final static QName _ListBookResponse_QNAME = new QName("http://soap.twf.cornflower/", "listBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cornflower.twf.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link JAXBException }
     * 
     */
    public JAXBException createJAXBException() {
        return new JAXBException();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link BookCopy }
     * 
     */
    public BookCopy createBookCopy() {
        return new BookCopy();
    }

    /**
     * Create an instance of {@link Books }
     * 
     */
    public Books createBooks() {
        return new Books();
    }

    /**
     * Create an instance of {@link DeleteBook }
     * 
     */
    public DeleteBook createDeleteBook() {
        return new DeleteBook();
    }

    /**
     * Create an instance of {@link DeleteBookResponse }
     * 
     */
    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    /**
     * Create an instance of {@link FetchBooks }
     * 
     */
    public FetchBooks createFetchBooks() {
        return new FetchBooks();
    }

    /**
     * Create an instance of {@link FetchBooksResponse }
     * 
     */
    public FetchBooksResponse createFetchBooksResponse() {
        return new FetchBooksResponse();
    }

    /**
     * Create an instance of {@link ListBook }
     * 
     */
    public ListBook createListBook() {
        return new ListBook();
    }

    /**
     * Create an instance of {@link ListBookResponse }
     * 
     */
    public ListBookResponse createListBookResponse() {
        return new ListBookResponse();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JAXBException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "JAXBException")
    public JAXBElement<JAXBException> createJAXBException(JAXBException value) {
        return new JAXBElement<JAXBException>(_JAXBException_QNAME, JAXBException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookCopy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "bookCopy")
    public JAXBElement<BookCopy> createBookCopy(BookCopy value) {
        return new JAXBElement<BookCopy>(_BookCopy_QNAME, BookCopy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Books }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "books")
    public JAXBElement<Books> createBooks(Books value) {
        return new JAXBElement<Books>(_Books_QNAME, Books.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "deleteBook")
    public JAXBElement<DeleteBook> createDeleteBook(DeleteBook value) {
        return new JAXBElement<DeleteBook>(_DeleteBook_QNAME, DeleteBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "deleteBookResponse")
    public JAXBElement<DeleteBookResponse> createDeleteBookResponse(DeleteBookResponse value) {
        return new JAXBElement<DeleteBookResponse>(_DeleteBookResponse_QNAME, DeleteBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "fetchBooks")
    public JAXBElement<FetchBooks> createFetchBooks(FetchBooks value) {
        return new JAXBElement<FetchBooks>(_FetchBooks_QNAME, FetchBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "fetchBooksResponse")
    public JAXBElement<FetchBooksResponse> createFetchBooksResponse(FetchBooksResponse value) {
        return new JAXBElement<FetchBooksResponse>(_FetchBooksResponse_QNAME, FetchBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "listBook")
    public JAXBElement<ListBook> createListBook(ListBook value) {
        return new JAXBElement<ListBook>(_ListBook_QNAME, ListBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.twf.cornflower/", name = "listBookResponse")
    public JAXBElement<ListBookResponse> createListBookResponse(ListBookResponse value) {
        return new JAXBElement<ListBookResponse>(_ListBookResponse_QNAME, ListBookResponse.class, null, value);
    }

}
