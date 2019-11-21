/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utilitaires.ContactDejaPresentException;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 * <b>AdressBook est la classe représentant la liste des contacts.</b>
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
 * Le surnom est optionel, tandis que toutes les autres informations décrites
 * ci-dessus sont obligatoires.
 * </p>
 * <p>
 * Un contact est identifié par le nom et le prénom.
 * </p>
 *
 * @see Contact
 * @author Abdeldjalil Guendouz
 * @version 2.0
 * @since 02-06-2019
 */
public class AddressBook extends ArrayList<Contact> {

    /**
     * Méthode pour rechercher et vérifier si un contact existe dans la liste
     * des contact (AdressBook), Retourne "True" si le contact existe dans la
     * liste sinon elle retourne "False"
     *
     * @param lastName Le nom du contact.
     * @param firstName Le prénom du contact.
     * @return Retourne "True" si le contact existe dans la liste sinon elle
     * retourne "False"
     *
     */
    public Contact rechercherContact(String lastName, String firstName) {

        for (Contact contact : this) {
            if ((contact.getLastName() == lastName) && (contact.getFirstName() == firstName)) {
                System.out.println("Existe");
                return contact;
            }
        }
        return null;
    }

    /**
     * Méthode pour Ajouter un contact dans la liste des contact (AdressBook),
     * si le contact n'existe pas déja dans la liste .
     *
     * @param contact Le contact à ajouter.
     * @throws ContactDejaPresentException Si le contact existe déja dans la
     * liste des contactes.
     *
     */
    public void ajouterContact(Contact contact) throws ContactDejaPresentException {

        if (!verifierDuplicata(contact)) {  // non existant
            this.add(contact);
            /* String infoContact = "Nom: " + contact.getLastName()+ "\n"   +   "Prenom: " + contact.getFirstName()+ "\n";
            JOptionPane.showMessageDialog(null,
                    "Contact a été ajouté avec succès !\n" + infoContact,
                    "Ajout complété", JOptionPane.INFORMATION_MESSAGE);*/
        } else {
            throw new ContactDejaPresentException("Erreur insertion, employe deja present",
                    contact);
        }
    }

    /**
     * Cette méthode est utilisée pour mettre à jour un contact dans la liste
     * des contact (AdressBook).
     *
     * @param contact Le contact à mettre à jour.
     * @param indice, la position (indice) du contact dans la liste des
     * contactes
     *
     */
    public void modifierContact(int indice, Contact contact) {
        if (indice < this.size()) {
            this.set(indice, contact);
        } else {
            //   ajouterContact(contact);
        }

    }

    /**
     * Cette méthode est utilisée pour supprimer un contact de la liste des
     * contact (AdressBook).
     *
     * @param contact Le contact à supprimer.
     * @param indice, la position (indice) du contact dans la liste des
     * contactes
     *
     */
    public void supprimerContact(int indice) {
        if (indice >= 0 && indice < this.size()) {
            this.remove(indice);
        } else {
            //  System.out.println("n existe pas");
        }

    }

    /**
     * Retourne l'objet contact de la position "indice".
     *
     * @param indice, la position (indice) du contact dans la liste des
     * contactes
     * @return le contact.
     *
     */
    public Contact getContact(int indice) {
        return this.get(indice);
    }

    /**
     * La méthode afficherList, permet l'affichage des contacts existent dans la
     * liste des contacts.
     *
     */
    public void afficherList() {

        for (Contact contact : this) {
            System.out.println(contact.toString());
        }
    }
    /**
     * Cette méthode est utilisée pour comparer un contact avec tous 
     * les contacts de la liste pour vérifier l'existance de ce contact.
     * elle retourne "True"si trouvé sinon elle retourne "False".
     *
     * @param contact Le contact à rechercher.
     *@return "True" si le contact est trouvé dans la liste sinon elle retourne "False"
     */
    private boolean verifierDuplicata(Contact contact) {  // verifier si ce contact est deja dans la liste des adresses
        for (Contact tmp : this) {
            if (tmp.equals(contact)) {
                return true;
            }
        }
        return false;
    }

}
