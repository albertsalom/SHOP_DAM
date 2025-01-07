package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@XmlRootElement(name = "productList")
public class ProductList {

    private List<Product> products;

    @XmlAttribute
    public int getTotal() {
        return products != null ? products.size() : 0;
    }

    @XmlElement(name = "product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
