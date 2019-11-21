/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 * <b>Contact est la classe représentant un objet de la listes des contacts.</b>
 * <p>
 * Un contact est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un nom (Last name), Un prénom (First name) et un surnom (Middle
 * name).</li>
 * <li>Un numéro de téléphone (Phone) et un courriel (Email)</li>
 * <li>Une ligne d'adresse 1 et2 nom (Last name)</li>
 * <li>Une ville, code Zip, province, et un pays</li>
 * </ul>
 * </p>
 * <p>
 * Le surnom et la deuxieme ligne d'adresse sont optionels, tandis que toutes 
 * les autres informations décrites ci-dessus sont obligatoires.
 * </p>
 * <p>
 * Un contact est identifié par le nom et le prénom.
 * </p>
 *
 *
 * @author Abdeldjalil Guendouz
 * @version 2.0
 * @since 02-06-2019
 */
public class Contact {

    private String lastName;    /** Le nom du contact */
    private String firstName;   /** Le prénom du contact */
    private String middleName;  /** Le surnom du contact */
    private String phone;       /** Le téléphone du contact */
    private String email;       /** Le courriel du contact */
    private String address1;    /** La premiere ligne d'adresse du contact */
    private String address2;    /** La deuxieme ligne d'adresse  du contact */
    private String city;        /** La ville du contact */
    private String state;       /** La province du contact */
    private String zip;         /** Le code postal (Zip) du contact */
    private String country;     /** Le pays du contact */

    /**
     * Constructeur Contact.
     * <p>
     * A la construction d'un objet Contact, un objet vide (avec des valeurs
     * nulls) sera créer.
     * </p>
     */
    public Contact() {
    }

    /**
     * Retourne le nom du contact.
     *
     * @return le nom du contact.
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retourne le prénom du contact.
     *
     * @return le prénom du contact.
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retourne le surnom du contact.
     *
     * @return le surnom du contact.
     *
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Retourne le téléphone du contact.
     *
     * @return le téléphone du contact.
     *
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Retourne le courriel du contact.
     *
     * @return le courriel du contact.
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retourne la premiere ligne d'adresse du contact.
     *
     * @return la premiere ligne d'adresse du contact.
     *
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Retourne la deuxieme ligne d'adresse du contact.
     *
     * @return la deuxieme ligne d'adresse du contact.
     *
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Retourne la ville du contact.
     *
     * @return la ville du contact.
     *
     */
    public String getCity() {
        return city;
    }

    /**
     * Retourne la province du contact.
     *
     * @return la province du contact.
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Retourne le code postal (Zip) du contact.
     *
     * @return le code postale (Zip) du contact.
     *
     */
    public String getZip() {
        return zip;
    }

    /**
     * Retourne le pays du contact.
     *
     * @return le pays du contact.
     *
     */
    public String getCountry() {
        return country;
    }

    /**
     * Met à jour le nom du contact.
     *
     * @param lastName Le nouveau nom du contact.
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Met à jour le prénom du contact.
     *
     * @param firstName  Le nouveau prénom du contact.
     *
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Met à jour le surnom du contact.
     *
     * @param middleName   Le nouveau surnom du contact.
     *
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    /**
     * Met à jour le téléphonr du contact.
     *
     * @param phone   Le nouveau téléphone du contact.
     *
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Met à jour le courriel du contact.
     *
     * @param email  Le nouveau courriel du contact.
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Met à jour la premiere ligne d'adresse du contact.
     *
     * @param address1  La premiere ligne d'adresse  du contact.
     *
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    /**
     * Met à jour la deuxieme ligne d'adresse du contact.
     *
     * @param address2  La deuxieme ligne d'adresse  du contact.
     *
     */
    public void setAddress2(String adress2) {
        this.address2 = adress2;
    }
    /**
     * Met à jour la ville du contact.
     *
     * @param city La ville du contact.
     *
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Met à jour la province du contact.
     *
     * @param city La province du contact.
     *
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * Met à jour le code postal (Zip) du contact.
     *
     * @param zip  le code postal (Zip) du contact.
     *
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    /**
     * Met à jour le pays du contact.
     *
     * @param country  le pays du contact.
     *
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * Retourne True si deux contacts sont identiques.
     * deux contacts sont identiques lorsque ils sont le meme nom et prenom.
     * @return True si deux contacts sont identiques.
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (!this.lastName.equalsIgnoreCase(other.lastName)) {
            return false;
        }
        if (!this.firstName.equalsIgnoreCase(other.firstName)) {
            return false;
        }
        return true;
    }
    /**
     * Retourne la description du contact.
     *
     * @return la description du contact.
     *
     */
    @Override
    public String toString() {
        return "Contact{" + "lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName + ", phone=" + phone + ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + '}';
    }
    /**
     * Retourne le nom complet (nom et prénom) du contact.
     *
     * @return le nom complet du contact.
     *
     */
    public String getFullName() {
        return this.getLastName() + ", " + this.getFirstName();
    }

}
