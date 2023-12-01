package com.neu.command_pattern;
import com.neu.Product;

//Purpose: to execute a command to rent a product.
public class RentProductCommand implements CommandAPI {

    private static RentProductCommand instance;  // Lazy Singleton Factory Class, ensure only one instance throughout the program
    private Product product;

    private RentProductCommand() {
        super();
    }

    public static synchronized RentProductCommand getInstance() {
        if (instance == null) {
            instance = new RentProductCommand();
        }
        return instance;
    }

    //When the execute() method is called, it will run the rentProduct() method to rent the product.
    @Override
    public String execute() {
        return product.rentProduct();
    }

    //Getter and setter
    public Product getProduct() {
        return product;
    }

    public RentProductCommand setProduct(Product product) {
        this.product = product;
        return this;
    }
}
