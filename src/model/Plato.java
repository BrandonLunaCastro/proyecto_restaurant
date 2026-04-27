package model;

public class Plato {
    private int id;
    private String name;
    private double price;
    private String category;

    public Plato(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    //Setters

    public void setId(int id){
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //Getters

    public int getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + name +
                " | Precio: $" + price +
                " | Categoría: " + category;
    }


}
