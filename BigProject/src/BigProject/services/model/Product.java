package BigProject.services.model;

import java.util.List;

public class Product {
    private int id;
    private String name; //Название
    private int amount; // Количество, Шт
    private double price; // Цена, грн.коп
    private int stock; // Склад

    public Product(int id, String name, int amount, double price, int stock){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.stock = stock;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return "[" + id + "; " + name + "; " + amount + "; " + price + "; " + stock + "]";
    }

}
