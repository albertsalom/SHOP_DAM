package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
public class Product {

    private static int counter = 0; // Contador para generar IDs únicos
    private int id;
    private String name;
    private BigDecimal wholesalerPrice;
    private BigDecimal publicPrice;
    private boolean available;
    private int stock;

    public Product() {
        this.id = ++counter; // Generar un ID único automáticamente
        this.available = true; // Valor predeterminado
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public BigDecimal getWholesalerPrice() {
        return wholesalerPrice;
    }

    public void setWholesalerPrice(BigDecimal wholesalerPrice) {
        this.wholesalerPrice = wholesalerPrice;
    }

    @XmlElement
    public BigDecimal getPublicPrice() {
        return wholesalerPrice != null ? wholesalerPrice.multiply(BigDecimal.valueOf(2)) : null;
    }

    @XmlElement
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @XmlElement
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
