package com.neu.command_pattern;

import com.neu.*;

//Purpose: to execute a command to buy a product.
public class BuyProductCommand implements CommandAPI {

    private static BuyProductCommand instance;  // Lazy Singleton Factory Class， ensure only one instance throughout the program
    private Product product;

    private BuyProductCommand() {
        super();
    }

    public static synchronized BuyProductCommand getInstance() {
        if (instance == null) {
            instance = new BuyProductCommand();
        }
        return instance;
    }

    //When the execute() method is called, it will run the buyProduct() method to buy the product.
    @Override
    public String execute() {
        return product.buyProduct();
    }

    //Getter and setter
    public Product getProduct() {
        return product;
    }

    public BuyProductCommand setProduct(Product product) {
        this.product = product;
        return this;
    }
}
