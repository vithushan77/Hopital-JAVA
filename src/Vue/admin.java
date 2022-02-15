package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	

	/**
	 * Create the application.
	 */
	public admin() {
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
		
		JButton btnNewButton = new JButton("RDV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(180, 50, 205, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajout utilisateur");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoututilisateur ajtu = new ajoututilisateur();
				ajtu.run();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(180, 102, 205, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hospitalisation");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitalisation hos = new hospitalisation();
				hos.run();
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(180, 154,  205, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voir des medecins");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(180, 200, 205, 40);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Déconnexion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connexion con = new connexion();
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(17, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton("Crée dossier patient");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dossierpatient dopat = new dossierpatient();
				dopat.run();
				frame.dispose();
			}
		});
		btnNewButton_5.setBounds(17, 72, 151, 70);
		frame.getContentPane().add(btnNewButton_5);
		
		
	}
}
