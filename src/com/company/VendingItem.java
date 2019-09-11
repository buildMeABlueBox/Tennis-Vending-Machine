package com.company;

public abstract class VendingItem {
    private String name;
    private double price;
    private int stock;
    private int itemId;

    public VendingItem(String name, double price, int stock, int itemId){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.itemId = itemId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setPrice(double price){
         this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void incrementStock(int amount){
        this.stock += amount;
    }

    public int getItemId(){
        return itemId;
    }
}
