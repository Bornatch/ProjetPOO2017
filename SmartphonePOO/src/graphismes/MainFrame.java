package graphismes;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Fonctions.ImageGalerie;
import fonctionsSmartphone.*;

public class MainFrame {
	
	protected JFrame frameSmartphone;
	
	private JPanel panelContact;
	private JPanel panelMenu;
	private JPanel panelNewContact;
	private JPanel galeriePhoto;
	private JPanel panelModifDeleteContact;
	
	private JLabel fondEcran;
	
	private JScrollPane listScroller;
	
	private JTextField firstNamef1;
	private JTextField lastNamef1;
	private JTextField firstNamef2;
	private JTextField lastNamef2;
	
	private JButton buttonMenu;
	private JButton buttonFermer;
	private JButton buttonVerrouiller;
	private JButton buttonGaleriePhoto;
	private JButton buttonContact;
	private JButton buttonAjouterContact;
	private JButton buttonSave;
	private JButton buttonDelete;
	private JButton buttonModify;
	private JButton cancelNewContact;
	private JButton cancelModification;
	
	private JList jlistContact ;
	int contactencours;
	
	public MainFrame() throws ClassNotFoundException, IOException {
		
		ArrayList<Contact> arraylistContact = new ArrayList<Contact>();
		
		ContactFile.DownloadDataContact("./BDDContacts",arraylistContact);
		
		jlistContact = new JList(arraylistContact.toArray());
		
		Contact newContact = new Contact();
		
		/*D�finition de la trame de fond*/
		frameSmartphone = new JFrame();
		frameSmartphone.setResizable(false);
		frameSmartphone.getContentPane().setBackground(Color.BLACK);
		frameSmartphone.setSize(430,750);
		frameSmartphone.setUndecorated(true);
		frameSmartphone.setLocationRelativeTo(null);		
		frameSmartphone.getContentPane().setLayout(null);
				
/*-------------------------------------------------------------------------------------------------------------------*/
/*CREATION DE TOUS LES PANELS*/
/*-------------------------------------------------------------------------------------------------------------------*/
		
	/*Cr�ation du menu de base*/
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0,0,0,150));
		panelMenu.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(panelMenu);
		panelMenu.setVisible(false);
		
	/*Cr�ation du panel contact*/
		panelContact = new JPanel();
		panelContact.setBackground(new Color(0,0,0,150));
		panelContact.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(panelContact);
		panelContact.setVisible(false);
		panelContact.setLayout(null);
		
	/*Cr�ation du panel nouveau contact*/
		panelNewContact = new JPanel();
		panelNewContact.setBackground(new Color(0,0,0,150));
		frameSmartphone.getContentPane().add(panelNewContact);
		panelNewContact.setVisible(false);
		panelNewContact.setLayout(null);
		panelNewContact.setBounds(15, 15, 400, 650);
		
	/*Cr�ation du panel nouveau contact*/
		panelModifDeleteContact = new JPanel();
		panelModifDeleteContact.setBackground(new Color(0,0,0,150));
		frameSmartphone.getContentPane().add(panelModifDeleteContact);
		panelModifDeleteContact.setVisible(false);
		panelModifDeleteContact.setLayout(null);
		panelModifDeleteContact.setBounds(15, 15, 400, 650);
		
	/*Cr�ation du panel galerie photo*/
		galeriePhoto = new JPanel();
		galeriePhoto.setBackground(new Color(0,0,0,150));
		galeriePhoto.setBounds(15, 15, 400, 650);
		//final JPanel galeriePhoto = new JPanel();
		PanelGalerie galeriePhoto = new PanelGalerie();
		frameSmartphone.getContentPane().add(galeriePhoto);
		
		fondEcran = new JLabel();
		fondEcran.setBounds(15, 15, 400, 650);
		frameSmartphone.getContentPane().add(fondEcran);
		fondEcran.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/fondEcran.jpg")));
		
/*-------------------------------------------------------------------------------------------------------------------*/
/*CREATION DE TOUT LES CHAMPS*/
/*-------------------------------------------------------------------------------------------------------------------*/
		
	/*Cr�ation des champs d'ajout de contact*/
		
		/*Pr�nom*/
		firstNamef1 = new JTextField();
		panelNewContact.add(firstNamef1);
		firstNamef1.setBounds(20, 200, 100, 30);

		/*Nom*/
		lastNamef1 = new JTextField();
		panelNewContact.add(lastNamef1);
		lastNamef1.setBounds(20, 250, 100, 30);
		
	/*Cr�ation des champs de modification de contact*/
		
		/*Pr�nom*/
		firstNamef2 = new JTextField();
		panelModifDeleteContact.add(firstNamef2);
		firstNamef2.setBounds(20, 200, 100, 30);

		/*Nom*/
		lastNamef2 = new JTextField();
		panelModifDeleteContact.add(lastNamef2);
		lastNamef2.setBounds(20, 250, 100, 30);
		
	/*Cr�ation des champs du menu contact*/
		
		/*Insertion de la liste des contacts*/
		panelContact.add(jlistContact);
		jlistContact.setBounds(0, 100, 400, 550);
		jlistContact.setBackground(new Color(215,216,216));
		jlistContact.setFixedCellHeight(45);
		jlistContact.setBorder(new EmptyBorder(0, 10, 0, 10));
		Font font = new Font("Roboto", Font.PLAIN, 15);
		jlistContact.setFont(font);
		
		listScroller = new JScrollPane(jlistContact);
		listScroller.setBounds(0, 100, 400, 550);
		listScroller.getVerticalScrollBar();
		jlistContact.setLayoutOrientation(JList.VERTICAL);
		panelContact.add(listScroller);
		
/*-------------------------------------------------------------------------------------------------------------------*/
/*CREATION DE TOUT LES BOUTONS*/
/*-------------------------------------------------------------------------------------------------------------------*/	
		
		panelMenu.setLayout(null);
		
	/*Cr�ation du bouton "Menu"*/
		buttonMenu = new JButton();
		buttonMenu.setBounds(190, 682, 50, 50);
		buttonMenu.setBackground(Color.black);
		buttonMenu.setBorder(null);
		buttonMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/home.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonMenu.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonMenu.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonMenu.setBackground(Color.black);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelContact.setVisible(false);
				galeriePhoto.setVisible(false);
				panelNewContact.setVisible(false);
				panelModifDeleteContact.setVisible(false);
			}
		});
		frameSmartphone.getContentPane().add(buttonMenu);
		
	/*Cr�ation du bouton "Fermer"*/
		buttonFermer = new JButton();
		buttonFermer.setBounds(280, 682, 50, 50);
		buttonFermer.setBackground(Color.black);
		buttonFermer.setBorder(null);
		buttonFermer.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/shutdown.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonFermer.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonFermer.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonFermer.setBackground(Color.black);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ContactFile.UploadDataContact(arraylistContact);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		frameSmartphone.getContentPane().add(buttonFermer);
		
	/*Cr�ation du bouton "Verrouiller"*/
		buttonVerrouiller = new JButton();
		buttonVerrouiller.setBounds(100, 682, 50, 50);
		buttonVerrouiller.setBackground(Color.black);
		buttonVerrouiller.setBorder(null);
		buttonVerrouiller.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/verrouiller.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonVerrouiller.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonVerrouiller.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonVerrouiller.setBackground(Color.black);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonVerrouiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelContact.setVisible(false);
				galeriePhoto.setVisible(false);
				panelNewContact.setVisible(false);
			}
		});
		frameSmartphone.getContentPane().add(buttonVerrouiller);
		
	/*Cr�ation du bouton "Acc�s galerie photo"*/
		buttonGaleriePhoto = new JButton();
		buttonGaleriePhoto.setBounds(25, 25, 100, 100);
		buttonGaleriePhoto.setBackground(Color.black);
		buttonGaleriePhoto.setBorder(null);
		buttonGaleriePhoto.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/logoPhoto.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonGaleriePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonGaleriePhoto.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonGaleriePhoto.setBackground(Color.black);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonGaleriePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				galeriePhoto.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		panelMenu.add(buttonGaleriePhoto);
		
	/*Cr�ation du bouton "Acc�s aux contacts"*/
		buttonContact = new JButton();
		buttonContact.setBounds(150, 25, 100, 100);
		buttonContact.setBackground(Color.black);
		buttonContact.setBorder(null);
		buttonContact.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/logoContact.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonContact.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonContact.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonContact.setBackground(Color.black);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContact.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		panelMenu.add(buttonContact);
		
	/*Cr�ation du bouton "Ajouter contact"*/
		buttonAjouterContact = new JButton();
		panelContact.add(buttonAjouterContact);
		buttonAjouterContact.setBounds(10, 10, 75, 75);
		buttonAjouterContact.setBackground(Color.black);
		buttonAjouterContact.setBorder(null);
		buttonAjouterContact.setIcon(new ImageIcon(MainFrame.class.getResource("/imagesSmartphone/addcontact.png")));
		
		/*Ajout du hover au survol de la souris*/
		buttonAjouterContact.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonAjouterContact.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonAjouterContact.setBackground(Color.black);
		    }
		});
				
		/*Ajout de l'action du bouton*/
		buttonAjouterContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewContact.setVisible(true);
				panelContact.setVisible(false);
			}
		});
		
		/*Cr�ation du bouton "Ajouter image"*/
//		JButton buttonAjouterImage = new JButton();
//		galeriePhoto.add(buttonAjouterImage);
//		buttonAjouterImage.setBounds(163, 575, 75, 75);
//		buttonAjouterImage.setBackground(Color.black);
//		buttonAjouterImage.setBorder(null);
//		buttonAjouterImage.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/004-technology-2.png")));
//		buttonAjouterImage.addMouseListener(new java.awt.event.MouseAdapter() {
//		    public void mouseEntered(java.awt.event.MouseEvent e) {
//		    	buttonAjouterImage.setBackground(Color.GRAY);
//		    }
//		    public void mouseExited(java.awt.event.MouseEvent e) {
//		    	buttonAjouterImage.setBackground(Color.black);
//		    }
//		});
//		buttonAjouterImage.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Graphics g = galeriePhoto.getGraphics();
//				Image image = Toolkit.getDefaultToolkit().getImage("/ImagesGalerie/img%20(1).jpg");
//				g.drawImage(image, 0, 0, null);
//			}
//		});
		
	/*Cr�ation du bouton "Sauvegarder"*/
		buttonSave = new JButton("Sauver");
		panelNewContact.add(buttonSave);
		buttonSave.setBounds(10, 590, 380, 50);
		buttonSave.setBackground(Color.green);
		buttonSave.setBorder(null);
		
		/*Ajout du hover au survol de la souris*/
		buttonSave.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonSave.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonSave.setBackground(Color.green);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				newContact.setFirstname(firstNamef1.getText());
				newContact.setLastname(lastNamef1.getText());
				
				arraylistContact.add(newContact);
				
				/*s�rialisation des contacts*/
				try {
					ContactFile.UploadDataContact(arraylistContact);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				/*Fermeture de la fen�tre actuelle afin de rafra�chir les donn�es de la JList*/
				frameSmartphone.dispose();
				
				/*Nouvelle ouverture du programme et chargement du panelContact*/
				MainFrame mainFrame;
				try {
					mainFrame = new MainFrame();
					mainFrame.frameSmartphone.setVisible(true);
					mainFrame.panelContact.setVisible(true);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
	/*Ajout de boutons sur le JList des contacts*/
		jlistContact.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent selectedContact) {
				
				contactencours = selectedContact.getLastIndex();
				
				firstNamef2.setText(arraylistContact.get(selectedContact.getLastIndex()).getFirstname());
				lastNamef2.setText(arraylistContact.get(selectedContact.getLastIndex()).getLastname());
				
				panelModifDeleteContact.setVisible(true);
				panelContact.setVisible(false);
				
			}
		});
		
	/*Cr�ation du bouton "Supprimer"*/
		buttonDelete = new JButton("Supprimer");
		buttonDelete.setForeground(Color.white);
		panelModifDeleteContact.add(buttonDelete);
		buttonDelete.setBounds(10, 590, 380, 50);
		buttonDelete.setBackground(Color.red);
		buttonDelete.setBorder(null);
		
		/*Ajout du hover au survol de la souris*/
		buttonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonDelete.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonDelete.setBackground(Color.red);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				newContact.setFirstname(firstNamef2.getText());
				newContact.setLastname(lastNamef2.getText());
				
				arraylistContact.remove(contactencours);
				
				/*s�rialisation des contacts*/
				try {
					ContactFile.UploadDataContact(arraylistContact);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				/*Fermeture de la fen�tre actuelle afin de rafra�chir les donn�es de la JList*/
				frameSmartphone.dispose();
				
				/*Nouvelle ouverture du programme et chargement du panelContact*/
				MainFrame mainFrame;
				try {
					mainFrame = new MainFrame();
					mainFrame.frameSmartphone.setVisible(true);
					mainFrame.panelContact.setVisible(true);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
		/*Cr�ation du bouton "Modifier"*/
		buttonModify = new JButton("Modifier");
		panelModifDeleteContact.add(buttonModify);
		buttonModify.setBounds(10, 530, 380, 50);
		buttonModify.setBackground(Color.green);
		buttonModify.setBorder(null);
		
		/*Ajout du hover au survol de la souris*/
		buttonModify.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	buttonModify.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	buttonModify.setBackground(Color.green);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				newContact.setFirstname(firstNamef2.getText());
				newContact.setLastname(lastNamef2.getText());
				
				arraylistContact.remove(contactencours);
				arraylistContact.add(newContact);
				
				/*s�rialisation des contacts*/
				try {
					ContactFile.UploadDataContact(arraylistContact);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				/*Fermeture de la fen�tre actuelle afin de rafra�chir les donn�es de la JList*/
				frameSmartphone.dispose();
				
				/*Nouvelle ouverture du programme et chargement du panelContact*/
				MainFrame mainFrame;
				try {
					mainFrame = new MainFrame();
					mainFrame.frameSmartphone.setVisible(true);
					mainFrame.panelContact.setVisible(true);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
		/*Cr�ation du bouton "Annuler" un nouveau contact*/
		cancelNewContact = new JButton("Annuler");
		panelNewContact.add(cancelNewContact);
		cancelNewContact.setBounds(10, 530, 380, 50);
		cancelNewContact.setBackground(Color.white);
		cancelNewContact.setBorder(null);
		
		/*Ajout du hover au survol de la souris*/
		cancelNewContact.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	cancelNewContact.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	cancelNewContact.setBackground(Color.white);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		cancelNewContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			panelNewContact.setVisible(false);
			panelContact.setVisible(true);
			}
		});
		
		/*Cr�ation du bouton "Annuler" une modification/suppression*/
		cancelModification = new JButton("Annuler");
		panelModifDeleteContact.add(cancelModification);
		cancelModification.setBounds(10, 470, 380, 50);
		cancelModification.setBackground(Color.white);
		cancelModification.setBorder(null);
		
		/*Ajout du hover au survol de la souris*/
		cancelModification.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		    	cancelModification.setBackground(Color.GRAY);
		    }
		    public void mouseExited(java.awt.event.MouseEvent e) {
		    	cancelModification.setBackground(Color.white);
		    }
		});
		
		/*Ajout de l'action du bouton*/
		cancelModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				panelModifDeleteContact.setVisible(false);
				panelContact.setVisible(true);		
			}
		});
	}
}
	

