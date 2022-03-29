package Vue;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Manager.Manager;
import Model.Chambres;
import Model.Patient;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoirUtilisateursbdd {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	/**

	 * Launch the application.

	 */

			public void run() {
				try {
					VoirUtilisateursbdd window = new VoirUtilisateursbdd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the application.
	 */
	public VoirUtilisateursbdd() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(550, 300, 553, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 10, 463, 339);
		frame.getContentPane().add(scrollPane);
		DefaultTableModel tblModel = new DefaultTableModel(
				new String[] {

						"Nom", "Prenom", "Mail", "Status"

				},0

				);

		table = new JTable(tblModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(201);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	int row = table.getSelectedRow();
		        int column = table.getSelectedColumn();
		       Object trucSelectionee = table.getValueAt(row, 2);
		       System.out.println(trucSelectionee);
		    }
		});

		Manager m = new Manager();
		ArrayList<Object[]> o = m.utilisateurs();
		for(int i = 0 ; i < o.size(); i ++) {
			tblModel.addRow(o.get(i));
		}
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(10, 372, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				administrateur cra = new administrateur();
				cra.run();
				frame.dispose();
				}
		});
		
		//ArrayList<String>liste= m.recupatient();
	}

}