/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaires;

import Model.AddressBook;
import Model.Contact;

/**
 * <b>ContactDejaPresentException:</b>
 * <p>
 * ContactDejaPresentException est une classe d'exception pour gérer les
 * exceptions sur les doublants
 * </p>
 *
 * @see Contact
 * @see AddressBook
 * @author Abdeldjalil Guendouz
 * @version 2.0
 * @since 02-06-2019
 */
public class ContactDejaPresentException extends Exception {

    private Contact contact;

    /**
     * Objet de la classe contact
     */
    /**
     * Constructeur ContactDejaPresentException.
     *
     */
    public ContactDejaPresentException(String message, Contact contact) {
        super(message);
        this.contact = contact;
    }

    /**
     * Retourne un objet contact.
     *
     * @return retourner le contact.
     *
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Mettre à jour un objet contact.
     *
     * @param contact
     * @see Contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    /**
     * Retourne la description du contact déja présent dans la liste book.
     *
     * @return la description du contact.
     *@see AddressBook.
     * @see Contact.
     */
    @Override
    public String toString() {
        return "ContactDejaPresentException{" + "contact=" + contact + '}';
    }

}
