package Vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class infirmiere {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					infirmiere window = new infirmiere();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the application.
	 */
	public infirmiere() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Chambre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chambrepati chmpat = new chambrepati();
				chmpat.run();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(110, 60, 199, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Commande");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandemedi commed = new commandemedi();
				commed.run();
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(106, 128, 203, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Médicament");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affiche_medicaments affmed = new affiche_medicaments();
				affmed.run();
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(110, 203, 199, 42);
		frame.getContentPane().add(btnNewButton_3);
	
		
		JButton btnNewButton_4 = new JButton("Déconnexion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connexion con = new connexion();
				frame.dispose();
			}
		});
		btnNewButton_4.setBounds(6, 6, 123, 42);
		frame.getContentPane().add(btnNewButton_4);
	}

}
