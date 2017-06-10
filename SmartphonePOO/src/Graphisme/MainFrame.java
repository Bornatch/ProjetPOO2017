package Graphisme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame {
	
	protected JFrame frameSmartphone;

	public MainFrame() {

		/*D�finition de la trame de fond*/
		frameSmartphone = new JFrame();
		frameSmartphone.setResizable(false);
		frameSmartphone.setTitle("Smartphone");
		frameSmartphone.getContentPane().setBackground(Color.BLACK);
		frameSmartphone.setSize(430,750);
		frameSmartphone.setUndecorated(true);
		frameSmartphone.setLocationRelativeTo(null);		
		frameSmartphone.getContentPane().setLayout(null);
				
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*CREATION DE TOUT LES PANELS*/
		/*-------------------------------------------------------------------------------------------------------------------*/
		
		/*Cr�ation du menu de base*/
		final JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0,0,0,150));
		panelMenu.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(panelMenu);
		panelMenu.setVisible(false);
		
		JLabel fondEcran = new JLabel();
		fondEcran.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(fondEcran);
		fondEcran.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/fondEcran.jpg")));
		
		/*Cr�ation du panel contact*/
		final JPanel panelContact = new JPanel();
		panelContact.setBackground(Color.DARK_GRAY);
		panelContact.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(panelContact);
		panelContact.setVisible(false);
		panelContact.setLayout(null);
		
		/*Cr�ation du panel nouveau contact*/
		final JPanel panelNewContact = new JPanel();
		panelNewContact.setBackground(Color.DARK_GRAY);
		panelNewContact.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(panelNewContact);
		panelNewContact.setVisible(false);
		panelContact.setLayout(null);
		
		/*Cr�ation du panel galerie photo*/
		final JPanel galeriePhoto = new JPanel();
		galeriePhoto.setBackground(Color.DARK_GRAY);
		galeriePhoto.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(galeriePhoto);
		galeriePhoto.setVisible(false);
		panelContact.setLayout(null);
		
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*CREATION DE TOUT LES CHAMPS*/
		/*-------------------------------------------------------------------------------------------------------------------*/
		
		/*Cr�ation des champs d'ajout de contact*/
		JTextField txtPrenom = new JTextField();
		txtPrenom.setText("Pr�nom ");
		txtPrenom.setBounds(166, 10, 262, 54);
		txtPrenom.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtPrenom.setText("");
		    }
		});
		panelNewContact.add(txtPrenom);
		
		JTextField txtNom = new JTextField();
		txtNom.setText("Nom ");
		txtNom.setBounds(166, 80, 262, 54);
		txtNom.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtNom.setText("");
		    }
		});
		panelNewContact.add(txtNom);
		
		/*-------------------------------------------------------------------------------------------------------------------*/
		/*CREATION DE TOUT LES BOUTONS*/
		/*-------------------------------------------------------------------------------------------------------------------*/	
		
		panelMenu.setLayout(null);
		
		/*Cr�ation du bouton "Menu"*/
		JButton buttonMenu = new JButton("Menu");
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelContact.setVisible(false);
				galeriePhoto.setVisible(false);
				panelNewContact.setVisible(false);
			}
		});
		buttonMenu.setBounds(180, 680, 50, 20);
		frameSmartphone.getContentPane().add(buttonMenu);
		
		/*Cr�ation du bouton "Acc�s galerie photo"*/
		JButton buttonGaleriePhoto = new JButton();
		buttonGaleriePhoto.setBounds(25, 25, 100, 100);
		buttonGaleriePhoto.setBackground(new Color(1));
		buttonGaleriePhoto.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/logoPhoto.png")));
		buttonGaleriePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				galeriePhoto.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		panelMenu.add(buttonGaleriePhoto);
		
		/*Cr�ation du bouton "Acc�s aux contacts"*/
		JButton buttonContact = new JButton();
		buttonContact.setBounds(150, 25, 100, 100);
		buttonContact.setBackground(new Color(1));
		buttonContact.setIcon(new ImageIcon(MainFrame.class.getResource("/Images/logoContact.png")));
		buttonContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContact.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		panelMenu.add(buttonContact);
		
		/*Cr�ation du bouton "Ajouter contact"*/
		JButton buttonAjouterContact = new JButton("Ajouter Contact");
		buttonAjouterContact.setBounds(0, 0, 197, 37);
		panelContact.add(buttonAjouterContact);
		buttonAjouterContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewContact.setVisible(true);
				panelContact.setVisible(false);
			}
		});
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFermer.setBounds(220, 670, 155, 37);
		frameSmartphone.getContentPane().add(btnFermer);
	}
}

