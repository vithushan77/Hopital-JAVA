package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import Manager.Manager;

public class administratif_rdv {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					administratif_rdv window = new administratif_rdv();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public administratif_rdv() {
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
		
		ArrayList<String> liste2 = man.recupmedecin();
		Object[] array2 = liste2.toArray();
		
		ArrayList<String> liste3 = man.recupheure();
		Object[] array3 = liste3.toArray();
		
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(144, 47, 94, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(array2);
		comboBox_1.setBounds(144, 78, 94, 21);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(array3);
		comboBox_2.setBounds(144, 109, 94, 21);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(291, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Prendre RDV");
		lblNewLabel.setBounds(113, 10, 198, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administratif adm = new administratif();
				adm.run();
				frame.dispose();
			
			}
		});
	}
}
