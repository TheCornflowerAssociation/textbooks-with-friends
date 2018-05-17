/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Laurence Presland
 */
public class Validator implements Serializable {
    
    private static Pattern emailPattern = Pattern.compile("^[A-Za-z\\._]+@[a-z\\-]+(\\.[a-z\\-]+)+$");
    private static Pattern yearPattern = Pattern.compile("^[0-9][0-9][0-9][0-9]$");
    private static Pattern isbnPattern = Pattern.compile("^[0-9]{3}\\-[0-9]\\-[0-9]{2}\\-[0-9]{6}\\-[0-9]$");
    
    public Validator() {
        super();
    }
    
    public static Boolean validEmail(String email) {
        Matcher m = emailPattern.matcher(email);
        return m.find();
    }
    
    public static Boolean validYear(String year) {
        Matcher m = yearPattern.matcher(year);
        return m.find();
    }
    
    public static Boolean validIsbn(String isbn) {
        Matcher m = isbnPattern.matcher(isbn);
        return m.find();
    }
}
