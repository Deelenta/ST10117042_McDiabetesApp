package com.varsitycollege.mcdiabetes;

public class Product
{

    private String burgerName;
    private String burgerPrice;

    public Product()
    {

    }

    public Product(String burgerName, String burgerPrice) {
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
    }


    public String getBurgerName(){
        return burgerName;
    }

    public void setBurgerName(String burgerName){
        this.burgerName = burgerName;
    }

    public String getBurgerPrice(){
        return burgerPrice;
    }

    public void setBurgerPrice(String burgerPrice){
        this.burgerPrice = burgerPrice;
    }
}
