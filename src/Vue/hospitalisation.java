package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JSpinner;

import Manager.Manager;
import Model.Chambres;
import Model.Medicaments;
import Model.Patient;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class hospitalisation {

	private static final JComboBox ComboBox_nom = null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospitalisation window = new hospitalisation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		//	}
	
	//});
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
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Manager man = new Manager();
		ArrayList<Patient>liste = 	man.recupatients();
		Object[] array = liste.toArray();
				
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(229, 20, 226, 27);
		frame.getContentPane().add(comboBox);
		
		
		ArrayList<Medicaments>listemed = man.recumpmed();
		Object[] array1 = listemed.toArray();
		JComboBox comboBox_1 = new JComboBox(array1);
		
		comboBox_1.setBounds(229, 88, 226, 27);
		frame.getContentPane().add(comboBox_1);
		
		ArrayList<Chambres>listecham = man.recuchambres();
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient selectValue = (Patient) comboBox.getSelectedItem();
				Chambres selectValue1 = (Chambres) comboBox_1_1.getSelectedItem();
				Medicaments selectValue2 = (Medicaments) comboBox_1.getSelectedItem();
				selectValue.getId();
				
				Manager man = new Manager();
				try {
					man.ajouthospit(selectValue.getId(),selectValue1.getId(),selectValue2.getId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
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


