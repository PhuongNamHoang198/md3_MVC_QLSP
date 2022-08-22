package model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private double cost;

    public Product() {
    }

    public Product(int id, String name, String brand, double cost) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
