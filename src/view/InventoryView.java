package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import main.Shop;
import utils.Constants;

public class InventoryView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Shop shop;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	try {
	//		InventoryView dialog = new InventoryView(shop);
	//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//		dialog.setVisible(true);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//}

	/**
	 * Create the dialog.
	 */
	public InventoryView(Shop shop) {
		setTitle("Inventario");
		
		this.shop = shop;
		
		
		
		setBounds(100, 100, 450, 300);
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
					},
					new String[] {
						"Codigo", "Nombre", "Precio publico", "Precio mayorista", "Stock", "Disponible"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
	}

}
