package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Manager.Manager;
import Model.Utilisateur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class VueUtilisateurs {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public VueUtilisateurs(Object trucSelectionnee) {
		initialize(trucSelectionnee);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object trucSelectionnee) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		Utilisateur ut = null;
		
		Manager ma = new Manager();
		ut = ma.getUtilisateurInfo(trucSelectionnee);
		
		textField = new JTextField(ut.getNom());
		textField.setBounds(10, 33, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(ut.getPrenom());
		textField_1.setBounds(10, 85, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField(ut.getMail());
		textField_3.setBounds(10, 180, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField(ut.getMdp());
		textField_2.setBounds(10, 137, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		String s1[] = { "administrateur", "administratif", "patient", "infirmiere", "stock" }; 
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(10, 232, 96, 21);
		frame.getContentPane().add(comboBox);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(31, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(31, 62, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de passe");
		lblNewLabel_3.setBounds(20, 114, 61, 13);
		frame.getContentPane().add(lblNewLabel_3);
	
		
		JLabel lblNewLabel_4 = new JLabel("Statut");
		lblNewLabel_4.setBounds(31, 209, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Activer");
		btnNewButton.setBounds(268, 58, 109, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mail = textField_3.getText();
					ma.updateActiver(mail);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_4.setText("Activé");
				frame.repaint();
				}
		});
		
		JButton btnNewButton_1 = new JButton("D\u00E9sactiver");
		btnNewButton_1.setBounds(268, 84, 109, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mail = textField_3.getText();
					ma.updateDesactiver(mail);;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_4.setText("Désactivé");
				frame.repaint();
				}
		});
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setBounds(268, 110, 109, 21);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					String Motdepasse = textField_2.getText();
					String Prenom = textField_1.getText();
					String Nom = textField.getText();
					String mail2 = textField_3.getText();
					Object Status = comboBox.getSelectedItem();
					Manager ma = new Manager();
					ma.updateProfil(mail2, Motdepasse, Nom, Prenom, Status);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Utilisateur_vue cra = new Utilisateur_vue();
				cra.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.setBounds(268, 136, 109, 21);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String mail2 = textField_3.getText();
					Manager ma = new Manager();
					ma.SupprimerProfilAdmin(mail2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Utilisateur_vue cra = new Utilisateur_vue();
				cra.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_4 = new JButton("Retour");
		btnNewButton_4.setBounds(277, 214, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setBounds(31, 157, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
			textField_4 = new JTextField("Activé");
		frame.repaint();
		textField_4.setBounds(139, 85, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Activation");
		lblNewLabel_5.setBounds(139, 62, 96, 13);
		frame.getContentPane().add(lblNewLabel_5);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Utilisateur_vue cra = new Utilisateur_vue();
				cra.run();
				frame.dispose();
				}
		});
	}
}
