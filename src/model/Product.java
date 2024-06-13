package model;

public class Product {
	private int id;
    private String name;
    private double publicPrice;
    private double wholesalerPrice;
    private boolean available;
    private int stock;
    private static int totalProducts;
    private boolean deluxe;
    
    static double EXPIRATION_RATE=0.60;
    
	public Product(String name, double wholesalerPrice, boolean available, int stock) {
		super();
		this.id = totalProducts+1;
		this.name = name;
		this.wholesalerPrice = wholesalerPrice;
		this.publicPrice = wholesalerPrice * 2;
		this.available = available;
		this.stock = stock;
		this.deluxe = deluxe;
		totalProducts++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPublicPrice() {
		return publicPrice;
	}

	public void setPublicPrice(double publicPrice) {
		this.publicPrice = publicPrice;
	}

	public double getWholesalerPrice() {
		return wholesalerPrice;
	}

	public void setWholesalerPrice(double wholesalerPrice) {
		this.wholesalerPrice = wholesalerPrice;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static int getTotalProducts() {
		return totalProducts;
	}

	public static void setTotalProducts(int totalProducts) {
		Product.totalProducts = totalProducts;
	}
	
	public void expire() {
		this.publicPrice = this.getPublicPrice()*EXPIRATION_RATE;
	}
	
	public boolean isDeluxe() {
		if (publicPrice	 >= 100) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setDeluxe(boolean deluxe) {
		this.deluxe = deluxe;
		
	}
	

	@Override
	public String toString() {
		return "ID: " + id + " | Nombre: " + name + " | Precio: " + publicPrice
				+ " | PrecioMayorista: " + wholesalerPrice + " | Disponibilidad:"
				+ " " + available + " | Stock: " + stock + " | Deluxe: " + deluxe;
	}	
    
}
