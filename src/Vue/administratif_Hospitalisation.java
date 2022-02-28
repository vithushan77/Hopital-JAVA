package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class administratif_Hospitalisation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					administratif_Hospitalisation window = new administratif_Hospitalisation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public administratif_Hospitalisation() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 66, 29, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(207, 145, 29, 21);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(306, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
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
		
		JLabel lblNewLabel = new JLabel("Hospitalisation");
		lblNewLabel.setBounds(201, 10, 73, 13);
		frame.getContentPane().add(lblNewLabel);
	}

}
