package fonctionsSmartphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Cette class permet la gestion des contacts. Il n'y a pas de contructeur mais 8 m�thodes de gestion :
*  OK1. Charger la liste (d�serialiser) 			: ChargerListContact
*  OK4. Sauver (s�rialiser) tous les contacts	: SauverListContact
*  OK5. Effacer un contact de la liste			: EffacerListContact
*  6. R�cup�rer l'id max de la list des cont.	: getMaxIdContact
*  7. Rendre le contact actif courrant			: setContactItem
*  8. Rendre le contact actif selon son id		: getContact
* @author Jacques
* @category Contact
* @see Contact
* @see ContactFileStream 
*/
public class ContactList {
	public static List<Contact> listContact = new ArrayList<Contact>();

	/*D�s�rialisation de la liste*/
	public static List<Contact> ChargerListContact() {
		fonctionsSmartphone.ContactFile cfs = new ContactFile();
		List<Contact> lstContact = cfs.readFromFile();
		return lstContact;
	}

	/* Sauver (s�rialiser) tous les contacts*/
	public static void SauverListContact(List<Contact> plstContact) {
		ContactList.listContact = plstContact;
		// S�rialisation
		fonctionsSmartphone.ContactFile cfs = new ContactFile();
		cfs.writeToFile(listContact);
	}
	
	/*Effacer un contact de la liste.*/
	public static void EffacerListContact(int indice) {
		listContact.remove(indice);
		// S�rialisation
		fonctionsSmartphone.ContactFile cfs = new ContactFile();
		cfs.writeToFile(listContact);
	}
}

