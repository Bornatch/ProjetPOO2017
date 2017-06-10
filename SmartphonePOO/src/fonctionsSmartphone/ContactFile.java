package fonctionsSmartphone;

import java.io.*;
import java.util.*;
/**
 * Permet la serialization et la d�serialisation de la class ListContact qui est une collections de Contact
 * Il n'y a pas de constructeur.
 * Deux m�thodes : 
 * 	1. writeToFile pour l'�criture du fichier
 * 	2. readFromFile pour lire le fichier
 * @author Jacques
 * @category Contact
 * @see Contact
 * @see ListContact
 *
 */
public class ContactFile {
	private String file = "Contact.serial";
/**
 * Pour la m�tode d'�criture du fichier de s�rialisation on passe un param�tre :
 * Une liste de contact
 * @param list
 */
	public void writeToFile(List<Contact> list) {
		ObjectOutputStream outStream = null;
		try {
			outStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Contact co : list) {
				if(co!=null)
					outStream.writeObject(co);
			}

		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		} catch (NoSuchElementException noSuchElementException) {
			System.err.println("Invalid input.");
		} finally {
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
	}
/**
 * La m�tode de lecture du fichier retourne une liste de contact
 * @return List<Contact>
 */
	public List<Contact> readFromFile() {
		List<Contact> list = new ArrayList<>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Contact co = (Contact) inputStream.readObject();
				list.add(co);
			}
		} catch (EOFException eofException) {
			return list;
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Object creation failed.");
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
		return list;
	}
}
