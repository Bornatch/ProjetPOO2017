package Fonctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Cette class permet la gestion des contacts. Il n'y a pas de contructeur mais 8 m�thodes de gestion :
*  1. Charger la liste (d�serialiser) 			: ChargerListContact
*  2. Trier la liste des contact (alphab�t.)	: TrierList
*  3. Effectuer une recherche					: ChercherContact
*  4. Sauver (s�rialiser) tous les contacts	: SauverListContact
*  5. Effacer un contact de la liste			: EffacerListContact
*  6. R�cup�rer l'id max de la list des cont.	: getMaxIdContact
*  7. Rendre le contact actif courrant			: setContactItem
*  8. Rendre le contact actif selon son id		: getContact
* @author Jacques
* @category Contact
* @see Contact
* @see ContactFileStream 
*/
public class ContactList {
	public static List<Contact> lstContact = new ArrayList<Contact>();

	/*D�s�rialisation de la liste*/
	public static List<Contact> ChargerListContact() {
		Fonctions.ContactFile cfs = new ContactFile();
		List<Contact> lstContact = cfs.readFromFile();
		return lstContact;
	}

	/* Sauver (s�rialiser) tous les contacts*/
	public static void SauverListContact(List<Contact> plstContact) {
		ListContact.lstContact = plstContact;
		lstContact = TrierList(lstContact);
		// S�rialisation
		classPhone.ContactFileStream cfs = new ContactFileStream();
		cfs.writeToFile(lstContact);
	}
/**
 * Effacer un contact de la liste. 
 * Trier la liste et s�rialiser
 * @see ContactFileStream.writeToFile
 * @param indice
 */
	public static void EffacerListContact(int indice) {
		lstContact.remove(indice);
		lstContact = TrierList(lstContact);
		// S�rialisation
		classPhone.ContactFileStream cfs = new ContactFileStream();
		cfs.writeToFile(lstContact);
	}

	/**
	 * Permet de setter le Contact actif lors de la sauvegarde apr�s modification
	 * Param�tre � passer un objet Contact
	 * @see saveEditContact
	 * @param co
	 */
	public static void setContactItem(Contact co){
		co.setNom(AppContact.fLastname.getText());
		co.setPrenom(AppContact.fFirstname.getText());
		co.setSociete(AppContact.fCompany.getText());
		co.setEmail(AppContact.fEmail.getText());
		co.setTelephone(AppContact.fPhone.getText());
		co.setImage(AppContact.fImage.getImageIcon());
		co.setIndexGroup(AppContact.fCGroup.getItem());
	}
	
///  A supprimer !!!	
	/*	public static int getMaxIdContact(){
	int max = 0;
	for (Contact co : lstContact) {
		if(co.getIdContact()>max){
			max=co.getIdContact();
		}
	}
	return max;
}*/
/*	public static Contact getContact(int idContact){
		for(Contact co : lstContact){
			if (idContact==co.getIdContact())
				return co;
		}
		return null;
	}	*/
}

