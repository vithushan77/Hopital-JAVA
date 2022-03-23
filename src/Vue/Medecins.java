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

public class Medecins {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medecins window = new Medecins();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Medecins() {
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
		scrollPane.setBounds(84, 88, 527, 281);
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
	}

}

