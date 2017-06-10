package Smartphone;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameContact extends Frame {
	
	JFrame frameContact;
	JPanel panelContact;
	JPanel panelNewContact;
	
	
	public FrameContact(){
		super();
		frameContact = new Frame();
		
		panelContact = new JPanel();
		panelContact.setBackground(Color.DARK_GRAY);
		panelContact.setBounds(15, 15, 450, 700);
		frameContact.getContentPane().add(panelContact);
		panelContact.setVisible(false);
		panelContact.setLayout(null);
		
		panelNewContact = new JPanel();
		panelNewContact.setBackground(Color.DARK_GRAY);
		panelNewContact.setBounds(15, 15, 450, 700);
		panelContact.getRootPane().add(panelNewContact);
		panelNewContact.setLayout(null);
		panelNewContact.setVisible(false);
		
		JButton AjouterPhoto = new JButton("+ Photo");
		AjouterPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		AjouterPhoto.setBounds(10, 10, 140, 140);
		panelNewContact.add(AjouterPhoto);
		
		JTextField txtfldTel = new JTextField();
		txtfldTel.setText("T�l�phone");
		txtfldTel.setBounds(166, 196, 262, 40);
		txtfldTel.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtfldTel.setText("");
		    }
		});
		panelNewContact.add(txtfldTel);
		
		JTextField txtfldPrnom = new JTextField();
		txtfldPrnom.setText("Pr�nom ");
		txtfldPrnom.setBounds(166, 10, 262, 54);
		txtfldPrnom.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtfldPrnom.setText("");
		    }
		});
		panelNewContact.add(txtfldPrnom);
		
		JTextField txtfldNom = new JTextField();
		txtfldNom.setText("Nom ");
		txtfldNom.setBounds(166, 80, 262, 54);
		txtfldNom.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtfldNom.setText("");
		    }
		});
		panelNewContact.add(txtfldNom);
		
		JTextField txtfldMail = new JTextField();
		txtfldMail.setText("E-Mail");
		txtfldMail.setBounds(166, 287, 262, 40);
		txtfldMail.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	txtfldMail.setText("");
		    }
		});
		panelNewContact.add(txtfldMail);
		
		JLabel lblTlphone = new JLabel("T�l�phone");
		lblTlphone.setForeground(Color.WHITE);
		lblTlphone.setBounds(20, 158, 154, 29);
		panelNewContact.add(lblTlphone);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mobile", "Bureau", "Domicile"}));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(10, 196, 126, 40);
		panelNewContact.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(20, 249, 154, 29);
		panelNewContact.add(lblEmail);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Domicile", "Bureau"}));
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setBackground(Color.DARK_GRAY);
		comboBox_1.setBounds(10, 287, 126, 40);
		panelNewContact.add(comboBox_1);
		
		JLabel lblAdressePostale = new JLabel("Adresse postale");
		lblAdressePostale.setForeground(Color.WHITE);
		lblAdressePostale.setBounds(20, 351, 229, 29);
		panelNewContact.add(lblAdressePostale);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Domicile", "Bureau"}));
		comboBox_2.setForeground(Color.WHITE);
		comboBox_2.setBackground(Color.DARK_GRAY);
		comboBox_2.setBounds(10, 390, 126, 40);
		panelNewContact.add(comboBox_2);
		
		JTextField txtRue = new JTextField();
		txtRue = new JTextField();
		txtRue.setText("Rue");
		txtRue.setBounds(166, 391, 262, 40);
		panelNewContact.add(txtRue);
		
			
		
		JButton btnAjouterContact = new JButton("Ajouter Contact");
		btnAjouterContact.setBounds(0, 0, 197, 37);
		panelContact.add(btnAjouterContact);
		btnAjouterContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewContact.setVisible(true);
				panelContact.setVisible(false);
			}
		});			
		
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrameMenu();
				
			}
		});
		buttonMenu.setBounds(215, 750, 50, 20);
		
		
	}
	

}
