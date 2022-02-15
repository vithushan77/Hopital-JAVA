package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JSpinner;

import Manager.Manager;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class hospitalisation {

	private static final JComboBox ComboBox_nom = null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					hospitalisation window = new hospitalisation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the application.
	 */
	public hospitalisation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.d
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Manager man = new Manager();
		ArrayList<String> liste = man.recupuser();
		Object[] array = liste.toArray();
				
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(229, 20, 226, 27);
		frame.getContentPane().add(comboBox);
		
		
		ArrayList<String> listemed = man.recupmed();
		Object[] array1 = listemed.toArray();
		JComboBox comboBox_1 = new JComboBox(array1);
		
		comboBox_1.setBounds(229, 88, 226, 27);
		frame.getContentPane().add(comboBox_1);
		
		ArrayList<String> listecham = man.recupcham();
		Object[]array2 = listecham.toArray();
		JComboBox comboBox_1_1 = new JComboBox(array2);
		
		comboBox_1_1.setBounds(229, 150, 226, 27);
		frame.getContentPane().add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad = new admin();
				ad.run();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(6, 250, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setBounds(454, 250, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	
		
		JLabel lblNewLabel = new JLabel("Patient");
		lblNewLabel.setBounds(36, 24, 117, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medicaments");
		lblNewLabel_1.setBounds(36, 92, 117, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chambre");
		lblNewLabel_2.setBounds(36, 154, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);
	}
	}


