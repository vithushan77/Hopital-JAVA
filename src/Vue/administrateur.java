package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class administrateur {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					administrateur window = new administrateur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public administrateur() {
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
		
		JButton btnNewButton = new JButton("Administrateur");
		btnNewButton.setBounds(130, 57, 148, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				creation_admin cra = new creation_admin();
				cra.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_1 = new JButton("Utilisateurs");
		btnNewButton_1.setBounds(130, 105, 148, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Utilisateur_vue uv = new Utilisateur_vue();
				uv.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_2 = new JButton("Voir utilisateurs");
		btnNewButton_2.setBounds(130, 149, 148, 21);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VoirUtilisateursbdd vu = new VoirUtilisateursbdd();
				vu.run();
				frame.dispose();
				}
		});
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Gestion des : ");
		lblNewLabel.setBounds(159, 10, 85, 13);
		frame.getContentPane().add(lblNewLabel);
	}

}
