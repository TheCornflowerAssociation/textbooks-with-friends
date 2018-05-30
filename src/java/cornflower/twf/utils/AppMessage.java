/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;


/**
 * A utility class for the AppMessage object.
 * 
 * @author J-Mo
 */
public class AppMessage {
    
    // Fields
    private String type;
    private String message;
    
    /**
     * A constructor for AppMessage.
     * 
     * @param type - the message type
     * @param message - the message text
     */
    public AppMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}

