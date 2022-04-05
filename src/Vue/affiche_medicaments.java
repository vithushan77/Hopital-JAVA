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
import Model.Medicaments;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class affiche_medicaments {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
				public void run() {
				try {
					affiche_medicaments window = new affiche_medicaments();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the application.
	 */
	public affiche_medicaments() {
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
						"id","nomMedicament", "quantite", "toxicite"
				},0
				);
		table = new JTable(tblModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);

		table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) { 

				int row = table.getSelectedRow(); 

				int column = table.getSelectedColumn(); 

				int trucSelectionee = (int) table.getValueAt(row, 0); 

				System.out.println(trucSelectionee); }

		});
		Manager m = new Manager();
		ArrayList<Object[]> o = m.prescription();
		for(int i = 0 ; i < o.size(); i ++) {
			tblModel.addRow(o.get(i));
		}
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Les medicaments");
		lblNewLabel.setBounds(279, 27, 117, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infirmiere ad = new infirmiere();
				ad.run();
				
			}
		});
		btnNewButton.setBounds(19, 419, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}

