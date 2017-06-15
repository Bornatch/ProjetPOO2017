package Fonctions;

import java.util.ArrayList;
import javax.swing.JList;

/*
 * Classe de gestion de la gallerie d'image
 */
public class MyListGallerie<Galerie> extends JList {
	
	private ArrayList<String> arrayImage = new ArrayList<String>();
	private int nombreImg=0;
	public ImageGallerie picture = new ImageGallerie();
	
	public Gallerie(){
		
	}

	public ArrayList<String> getArrayImage() {
		return arrayImage;
	}

	public void setArrayImage(ArrayList<String> arrayImage) {
		this.arrayImage = arrayImage;
	}

	public int getNombreImg() {
		return nombreImg;
	}

	public void setNombreImg(int nombreImg) {
		this.nombreImg = nombreImg;
	}

}