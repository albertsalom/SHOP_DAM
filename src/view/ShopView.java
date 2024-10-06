package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Shop;
import utils.Constants;

import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class ShopView extends JFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private JButton btnExportInventory;
	private JPanel contentPane;
	private JButton btnOption1;
	private JButton btnOption2;
	private JButton btnOption3;
	private JButton btnOption5;
	private JButton btnOption9;
	public Shop shop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopView frame = new ShopView();
					frame.setVisible(true);
					frame.setTitle("Shop");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopView() {
		this.shop = new Shop();
		
		shop.loadInventory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("MyShop.com");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectOption = new JLabel("Seleccione o pulse una opción");
		lblSelectOption.setBounds(49, 25, 188, 14);
		contentPane.add(lblSelectOption);
		
		btnExportInventory = new JButton("0. Exportar inventario");
		btnExportInventory.addActionListener(this);
		btnExportInventory.setBounds(80, 50, 160, 23);
		contentPane.add(btnExportInventory);
		
		btnOption1 = new JButton("1. Contar Caja");
		btnOption1.addActionListener(this);
		btnOption1.setBounds(80, 80, 160, 23);
		contentPane.add(btnOption1);
		
		btnOption2 = new JButton("2. Añadir Producto");
		btnOption2.addActionListener(this);
		btnOption2.setBounds(80, 110, 160, 23);
		contentPane.add(btnOption2);
		
		btnOption3 = new JButton("3. Añadir Stock");
		btnOption3.addActionListener(this);
		btnOption3.setBounds(80, 140, 160, 23);
		contentPane.add(btnOption3);
		
		btnOption5 = new JButton("5. Mostrar Inventario");
		btnOption5.addActionListener(this);
		btnOption5.setBounds(80, 170, 160, 23);
		contentPane.add(btnOption5);
		
		btnOption9 = new JButton("9. Eliminar Producto");
		btnOption9.addActionListener(this);
		btnOption9.setBounds(80, 200, 160, 23);
		contentPane.add(btnOption9);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnExportInventory) {
				openExportInventory(shop);
			}
			if (e.getSource() == btnOption1) {
				openCashView(shop);
			}
			
			if (e.getSource() == btnOption2) {
				OpenProductView(shop, Constants.OPTION_ADD_PRODUCT);
			}
			
			if (e.getSource() == btnOption3) {
				OpenProductView(shop, Constants.OPTION_ADD_STOCK);
			}
			
			if (e.getSource() == btnOption5) {
				OpenInventoryView(shop);
			}
			
			if (e.getSource() == btnOption9) {
				OpenProductView(shop, Constants.OPTION_DELETE_PRODUCT);
			}
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void openExportInventory() {
		if (!shop.writeInventory()) {
			JOptionPane.showMessageDialog(this, "Unable to export inventory to file", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Inventory exported successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void openCashView(Shop shop) {
		CashView cashView = new CashView(shop);
		cashView.setVisible(true);
	}
	
	public void OpenProductView(Shop shop, int mode) {
		ProductView productView = new ProductView(shop, mode);
		productView.setVisible(true);
	}
	
	public void OpenInventoryView(Shop shop) {
		InventoryView inventoryView = new InventoryView(shop);
		inventoryView.setVisible(true);
	}
}
