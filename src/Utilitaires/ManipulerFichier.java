/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaires;

import Model.AddressBook;
import Model.Contact;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * <b>ManipulerFichier:</b>
 * <p>
 * ManipulerFichier est une classe qui contient des méthodes permettants la 
 * manipulation des fichiers textes (Lecture, ecriture,etc).
 * </p>
 *
 * @author Abdeldjalil Guendouz
 * @version 2.0
 * @since 02-06-2019
 */
public class ManipulerFichier {

    /**
     * <p>
     * lectureFichier est une méthode utilisée pour la lecture des contacts 
     * à partir  d'un fichier texte et les charger dans la liste des contacts
     *</p>
     * @param book La liste des contacts (AdressBook).
     * @param  file le nom du fichier text (data.txt)
     * 
     */
    public static void lectureFichier(AddressBook book, String file) {
        String line; //file = "data.txt";

        try {
            FileReader fr = new FileReader(new File(file));
            //utilisation de buffer de lecture
            BufferedReader inFile = new BufferedReader(fr);
            // line = inFile.readLine();
            while ((line = inFile.readLine()) != null) {
                try {
                    //  Contact contact = ;
                    book.ajouterContact(parseLigne(line));
                } catch (ContactDejaPresentException ex) {
                    Logger.getLogger(ManipulerFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            inFile.close();

        } catch (FileNotFoundException exception) {
            System.out.println("Fichier: " + file + " introuvable.");
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
    /**
     * <p>
     * parseLigne est une méthode permettant de créer et retourner un objet 
     * contact à partir  d'une ligne text (du fichier text) .
     *</p>
     * @param line La ligne du fichier text.
     * @return  retourner un contact.
     * @see  Contact.
     * 
     */
    public static Contact parseLigne(String line) {
        String[] tokens = new String[11];
        Contact contact = new Contact();

        if (line != null) {

            tokens = line.split(";");
            contact.setLastName(tokens[0]);
            contact.setFirstName(tokens[1]);
            contact.setMiddleName(tokens[2]);
            contact.setPhone(tokens[3]);
            contact.setEmail(tokens[4]);
            contact.setAddress1(tokens[5]);
            contact.setAddress2(tokens[6]);
            contact.setCity(tokens[7]);
            contact.setState(tokens[8]);
            contact.setZip(tokens[9]);
            contact.setCountry(tokens[10]);

            return contact;
        }

        return null;
    }

    /**
     * <p>
     * ecrireFichier est une méthode permettant l'ecriture dans un fichier text
     * les lignes de contacts à partir  d'une listede contacts .
     *</p>
     * @param book La liste de contacts (AdressBook).
     * @param nomFichier  le nom du fichier de sortie
     * @see  Contact.
     * @see AdressBook
     * 
     */
    public static void ecrireFichier(String nomFichier, AddressBook book) {

        File file = new File(nomFichier);
        FileWriter fw = null;
        BufferedWriter bw = null;

        String ligne;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (Contact contact : book) {
                ligne = formerLigneCSV(contact);
                bw.write(ligne);
            }
        } catch (IOException ex) {
            Logger.getLogger(ManipulerFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ManipulerFichier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     * <p>
     * formerLigneCSV est une méthode permettant de créer (transformer)
     * et retourner un ligne (chaine de caracteres) à partir  d'un objet contact.
     *</p>
     * @param contact  Le contact à transformer.
     * @return  ligne (chaine de caracteres) contenat le nom, prenom, etc.
     * @see  Contact.
     * 
     */
    private static String formerLigneCSV(Contact contact) {
        return contact.getLastName() + ";" + contact.getFirstName() + ";"
                + contact.getMiddleName() + ";" + contact.getPhone() + ";"
                + contact.getEmail() + ";" + contact.getAddress1() + ";"
                + contact.getAddress2() + ";" + contact.getCity() + ";"
                + contact.getState() + ";" + contact.getZip() + ";"
                + contact.getCountry() + "\n";
    }

     /**
     * <p>
     * remplirList est une méthode permettant de mettre la listes des contacts
     * dans la list(Jlist).
     *</p>
     * @param list  La list (Jlist) de l'interface graphique.
     *@param book La liste de contacts (AdressBook).
     * @see  Contact.
     * @see  AddressBook.
     * 
     */
    public static void remplirList(JList list, AddressBook book) {
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        int pos;
        String ligne;
        for (Contact contact : book) {
            pos = list.getModel().getSize();
            ligne = contact.getFullName();
            model.add(pos, ligne);
        }
    }

   /* 
    public static void addToList(JList list, AddressBook book, Contact contact) {
        DefaultListModel model = new DefaultListModel();
        list.setModel(model);
        int pos;
        String ligne;
        pos = list.getModel().getSize();
        try {
            book.ajouterContact(contact);
        } catch (ContactDejaPresentException ex) {
            Logger.getLogger(ManipulerFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
        ligne = contact.getFullName();
        model.add(pos, ligne);
    } */

}
