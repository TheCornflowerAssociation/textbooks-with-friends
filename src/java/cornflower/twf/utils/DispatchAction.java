/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornflower.twf.utils;

/**
 *
 * @author J-Mo
 */
public class DispatchAction {
    
    private String modal;
    private String message;
    
    public DispatchAction(String modal, String message) {
        this.modal = modal;
        this.message = message;
    }

    public String getModal() {
        return modal;
    }

    public String getMessage() {
        return message;
    }
}
