package Vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Manager.Manager;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class rdv {

	private JFrame frame;
	private JTextField DATE;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					rdv window = new rdv();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public rdv() {
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
		
		Manager man = new Manager();
		ArrayList<String> liste = man.recupuser();
		Object[] array = liste.toArray();
		
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(155, 39, 155, 27);
		frame.getContentPane().add(comboBox);
		
		ArrayList<String> liste1 = man.medecins();
		Object[] array1 = liste1.toArray();
		JComboBox comboBox_1 = new JComboBox(array1);
		comboBox_1.setBounds(155, 98, 155, 21);
		frame.getContentPane().add(comboBox_1);
		
		ArrayList<String> time = man.heure();
		Object[] heure = time.toArray();
		JComboBox comboBox_2 = new JComboBox(heure);
		comboBox_2.setBounds(155, 144, 155, 27);
		frame.getContentPane().add(comboBox_2);
		
		DATE = new JTextField("JJ/MM/AA");
		DATE.setBounds(155, 201, 155, 26);
		frame.getContentPane().add(DATE);
		DATE.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Patient");
		lblNewLabel.setBounds(6, 43, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medecin");
		lblNewLabel_1.setBounds(6, 99, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Heure");
		lblNewLabel_2.setBounds(6, 148, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(6, 206, 95, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(313, 226, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad = new admin();
				ad.run();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(6, 234, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
