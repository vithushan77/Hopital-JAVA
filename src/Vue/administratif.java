package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class administratif {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					administratif window = new administratif();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public administratif() {
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
		
		JButton btnNewButton = new JButton("RDV");
		btnNewButton.setBounds(10, 49, 129, 71);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratif_rdv rdv = new administratif_rdv();
				rdv.run();
				frame.dispose();
			
			}
		});
		
		JButton btnNewButton_1 = new JButton("Hospitalisation");
		btnNewButton_1.setBounds(257, 49, 129, 71);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratif_Hospitalisation hsp = new administratif_Hospitalisation();
				hsp.run();
				frame.dispose();
			
			}
		});
		
		JButton btnNewButton_2 = new JButton("Créer dossier patient");
		btnNewButton_2.setBounds(10, 151, 129, 71);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratif_dossierpatient dos = new administratif_dossierpatient();
				dos.run();
				frame.dispose();
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Dispo médecin");
		btnNewButton_3.setBounds(257, 158, 129, 71);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratif_dispo dis = new administratif_dispo();
				dis.run();
				frame.dispose();
			
			}
		});
		
		JButton btnNewButton_4 = new JButton("Déconnexion");
		btnNewButton_4.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			
			}
		});
		
		JLabel lblNewLabel = new JLabel("Panel administratif");
		lblNewLabel.setBounds(158, 10, 253, 13);
		frame.getContentPane().add(lblNewLabel);
	}
}
