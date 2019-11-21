package Control;

import Model.AddressBook;
import Vue.AddressBookGui;
import com.sun.jndi.cosnaming.IiopUrl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AppCtr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  AdressBookGui adrGui = new AdressBookGui();
        /* Create and display the form */
        AddressBook book = new AddressBook();
        String file="data.txt";
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddressBookGui(book,file).setVisible(true);
            }
        });
    }
    
}
