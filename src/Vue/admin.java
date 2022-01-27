package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	

	/**
	 * Create the application.
	 */
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("RDV");
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("../Hopital-Java/src/img/rdv.jpeg"));
		btnNewButton.setBounds(24, 22, 326, 211);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hopitalisation");
		btnNewButton_1.setBounds(524, 22, 326, 211);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Creé dosier patient");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoututilisateur ajtu = new ajoututilisateur();
				ajtu.run();
			}
		});
		btnNewButton_2.setBounds(24, 255, 326, 211);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("voir des médecins");
		btnNewButton_3.setBounds(524, 255, 326, 211);
		frame.getContentPane().add(btnNewButton_3);
	}


}
