package Vue;

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
	private JTextField telephone;
	private JTextField social;
	private JTextField Mutuelle;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		telephone = new JTextField();
		telephone.setBounds(171, 63, 130, 26);
		frame.getContentPane().add(telephone);
		telephone.setColumns(10);
		
		social = new JTextField();
		social.setBounds(171, 101, 130, 26);
		frame.getContentPane().add(social);
		social.setColumns(10);
		
		Mutuelle = new JTextField();
		Mutuelle.setBounds(171, 139, 130, 26);
		frame.getContentPane().add(Mutuelle);
		Mutuelle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Téléphone");
		lblNewLabel.setBounds(33, 68, 102, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sécurité social");
		lblNewLabel_1.setBounds(33, 106, 102, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mutuelle");
		lblNewLabel_2.setBounds(33, 144, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Information en plus");
		lblNewLabel_4.setBounds(146, 17, 163, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(18, 207, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient dopt = new Patient();
				dopt.setTelephone(telephone.getText());
				dopt.setSecuriteSocial(social.getText());
				dopt.setMutuelle(Mutuelle.getText());
				
				Manager man = new Manager();
				man.connexionbdd();
				man.informationsupp(dopt);
			}
		});
		btnNewButton_1.setBounds(290, 207, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
