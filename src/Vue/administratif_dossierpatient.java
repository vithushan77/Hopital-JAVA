package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class administratif_dossierpatient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					administratif_dossierpatient window = new administratif_dossierpatient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public administratif_dossierpatient() {
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
		
		textField = new JTextField();
		textField.setBounds(139, 45, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 74, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 103, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 132, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(139, 161, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(139, 190, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(301, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 48, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom");
		lblNewLabel_1.setBounds(10, 77, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(10, 106, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Téléphone");
		lblNewLabel_3.setBounds(10, 135, 96, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mutuelle");
		lblNewLabel_4.setBounds(10, 164, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SécuritéSociale");
		lblNewLabel_5.setBounds(10, 193, 96, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ajout de patient");
		lblNewLabel_6.setBounds(139, 10, 166, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(0, 232, 85, 21);
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
