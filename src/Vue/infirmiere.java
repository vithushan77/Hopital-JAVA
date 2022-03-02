package Vue;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Traitement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicaments tra = new medicaments();
				tra.run();
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(218, 6, 199, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("chambre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(218, 60, 199, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Commande");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandemedi commed = new commandemedi();
				commed.run();
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(218, 122, 203, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Médicament");
		btnNewButton_3.setBounds(224, 189, 193, 42);
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