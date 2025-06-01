package tniteam.marketplaceb2b.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;






@Entity
public class Product{
    @Id
    private int id;
    private String name;
    private double price;
    private int quantity;
    @ManyToOne
    @JsonBackReference
    private Category category;

    public Product() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}