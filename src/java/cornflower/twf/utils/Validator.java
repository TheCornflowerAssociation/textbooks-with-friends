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
    private static Pattern isbnPattern = Pattern.compile("^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$");
    private static Pattern textPattern = Pattern.compile("^[a-zA-Z ,.0-9\n&:;\"']+$");
    private static Pattern numberPattern = Pattern.compile("^\\d+$");
    private static Pattern emptyPattern = Pattern.compile("^.+$");
    
    /**
     * A constructor for the validator object
     *
     */
    public Validator() {
        super();
    }
    
    /**
     * Check if a given email is valid
     *
     * @param input - The email to validate
     * @return
     */
    public AppMessage validEmail(String input) {
        if (!emailPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid email address. Please enter a valid one e.g. winston@gmail.com.");
        }
        return null;
    }
    
    /**
     * Check if a given is valid
     *
     * @param input - The year to validate
     * @return
     */
    public AppMessage validYear(String input) {
        if (!yearPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid year. Please enter a valid one e.g. 1984.");
        }
        return null;
    }
    
    /**
     * Check if a given ISBN is valid
     *
     * @param input - The ISBN to validate
     * @return
     */
    public AppMessage validIsbn(String input) {
        if (!isbnPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid ISBN. Please enter a valid one e.g. 978-1-47-133143-5.");
        }
        return null;
    }
    
    /**
     * Check if a given piece of text is valid
     *
     * @param input - The piece of text to validate
     * @param type - The field from which the input originated
     * @return
     */
    public AppMessage validText(String input, String type) {
        if (!textPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered invalid text in the " + type + " field. Please make sure the information you have entered is correct.");
        }
        return null;
    }
    
    /**
     * Check if a given number is valid
     *
     * @param input
     * @param type - The field from which the input originated
     * @return
     */
    public AppMessage validNumber(String input, String type) {
        if (!numberPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid number in the " + type + " field. Please make sure the information you have entered is correct.");
        }
        return null;
    }
    
    /**
     * Check if a given string is empty
     *
     * @param input - The string to test
     * @return
     */
    public AppMessage notEmpty(String input) {
        if (!emptyPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have not filled in all required fields. Please make sure you fill in all required fields.");
        }
        return null;
    }
}
