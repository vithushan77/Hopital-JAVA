package Vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Manager.Manager;
import Model.Patient;
import Model.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dossierpatient {

	private JFrame frame;
	private JTextField nompatient;
	private JTextField prenompatient;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField social;
	private JTextField Mutuelle;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					dossierpatient window = new dossierpatient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public dossierpatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		telephone = new JTextField();
		telephone.setBounds(171, 131, 221, 26);
		frame.getContentPane().add(telephone);
		telephone.setColumns(10);
		
		social = new JTextField();
		social.setBounds(171, 159, 221, 26);
		frame.getContentPane().add(social);
		social.setColumns(10);
		
		Mutuelle = new JTextField();
		Mutuelle.setBounds(171, 187, 221, 26);
		frame.getContentPane().add(Mutuelle);
		Mutuelle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Téléphone");
		lblNewLabel.setBounds(33, 136, 102, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sécurité social");
		lblNewLabel_1.setBounds(33, 164, 102, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mutuelle");
		lblNewLabel_2.setBounds(33, 192, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Information en plus");
		lblNewLabel_4.setBounds(146, 17, 163, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad = new admin();
				ad.run();
				frame.dispose();
						
			}
		});
		btnNewButton.setBounds(18, 225, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient dopt = new Patient(0,nompatient.getText(),prenompatient.getText(),adresse.getText(), telephone.getText(),Mutuelle.getText(),social.getText());
				dopt.setSecuriteSocial(nompatient.getText());
				dopt.setSecuriteSocial(prenompatient.getText());
				dopt.setSecuriteSocial(adresse.getText());
				dopt.setTelephone(telephone.getText());
				dopt.setMutuelle(Mutuelle.getText());
				dopt.setSecuriteSocial(social.getText());
				
				
				Manager man = new Manager();
				man.connexionbdd();
				man.informationsupp(dopt);
			}
		});
		btnNewButton_1.setBounds(291, 225, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Nom patient");
		lblNewLabel_3.setBounds(33, 51, 102, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Prenom Patient");
		lblNewLabel_5.setBounds(33, 79, 94, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Adresse");
		lblNewLabel_6.setBounds(33, 107, 94, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		nompatient = new JTextField();
		nompatient.setBounds(171, 46, 221, 26);
		frame.getContentPane().add(nompatient);
		nompatient.setColumns(10);
		
		prenompatient = new JTextField();
		prenompatient.setBounds(171, 74, 221, 26);
		frame.getContentPane().add(prenompatient);
		prenompatient.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(171, 102, 221, 26);
		frame.getContentPane().add(adresse);
		adresse.setColumns(10);
	}
}
