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
    private static Pattern textPattern = Pattern.compile("^[a-zA-Z]+$");
    private static Pattern numberPattern = Pattern.compile("^\\d+$");
    private static Pattern emptyPattern = Pattern.compile("^.+$");
    
    public Validator() {
        super();
    }
    
    public AppMessage validEmail(String input) {
        if (!emailPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid email address. Please go back and enter a valid one.");
        }
        return null;
    }
    
    public AppMessage validYear(String input) {
        if (!yearPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid year. Please go back and enter a valid one.");
        }
        return null;
    }
    
    public AppMessage validIsbn(String input) {
        if (!isbnPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered an invalid ISBN. Please go back and enter a valid one.");
        }
        return null;
    }
    
    public AppMessage validText(String input) {
        if (!textPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered invalid information. Please go back and make sure the information you have entered is correct.");
        }
        return null;
    }
    
    public AppMessage validNumber(String input) {
        if (!numberPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have entered invalid information. Please go back and make sure the information you have entered is correct.");
        }
        return null;
    }
    
    public AppMessage notEmpty(String input) {
        if (!emptyPattern.matcher(input).find()) {
            return new AppMessage("danger", "You have not filled in all required fields. Please go back and make sure you fill in all required fields.");
        }
        return null;
    }
}
