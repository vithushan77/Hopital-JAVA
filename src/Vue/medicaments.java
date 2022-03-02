package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import Manager.Manager;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class medicaments {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					medicaments window = new medicaments();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the application.
	 */
	public medicaments() {
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
		ArrayList<String> liste = man.recupuser();
		Object[] array = liste.toArray();
		
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(153, 31, 216, 61);
		frame.getContentPane().add(comboBox);
		
		ArrayList<String> listemed = man.recupmed();
		Object[] array1 = listemed.toArray();
		JComboBox comboBox_1 = new JComboBox(array1);
		comboBox_1.setBounds(153, 104, 216, 61);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(294, 209, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient");
		lblNewLabel.setBounds(29, 52, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medicaments");
		lblNewLabel_1.setBounds(29, 125, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infirmiere inf = new infirmiere();
				inf.run();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(6, 209, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}