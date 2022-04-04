package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Manager.Manager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Affiche_medecins {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					Affiche_medecins window = new Affiche_medecins();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the application.
	 */
	public Affiche_medecins() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(550, 300, 700, 500);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 105, 527, 281);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		DefaultTableModel tblModel = new DefaultTableModel(

				new String[] {
						"id","Nom", "specialité"
				},0
				);
		table = new JTable(tblModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 

				int row = table.getSelectedRow(); 

				int column = table.getSelectedColumn(); 

				int trucSelectionee = (int) table.getValueAt(row, 0); 

				System.out.println(trucSelectionee); }

		});
		Manager m = new Manager();
		ArrayList<Object[]> o = m.doctor();
		for(int i = 0 ; i < o.size(); i ++) {
			tblModel.addRow(o.get(i));
		}
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Les medecins");
		lblNewLabel.setBounds(279, 27, 117, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin ad = new admin();
				ad.run();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(19, 419, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}

