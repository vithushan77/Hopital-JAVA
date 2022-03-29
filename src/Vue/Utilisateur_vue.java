package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Manager.Manager;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;

public class Utilisateur_vue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Utilisateur_vue window = new Utilisateur_vue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public Utilisateur_vue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Manager man = new Manager();
		ArrayList<String> liste = man.alluser();
		Object[] array = liste.toArray();
		
		
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(138, 112, 157, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Selection utilisateurs : ");
		lblNewLabel.setBounds(145, 10, 165, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(166, 217, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object trucSelectionnee = comboBox.getSelectedItem();
				System.out.println(trucSelectionnee);
				frame.dispose();
				VueUtilisateurs uv = new VueUtilisateurs(trucSelectionnee);
				
				}
		});
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				administrateur cra = new administrateur();
				cra.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.setBounds(166, 183, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AjouterUtilisateur uv = new AjouterUtilisateur();
				uv.run();
				frame.dispose();
				}
		});
	}

}
