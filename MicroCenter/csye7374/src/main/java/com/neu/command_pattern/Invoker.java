package com.neu.command_pattern;
import java.util.*;
import com.neu.Product;

//The Invoker class acts as the invoker of commands, holding a list of product orders in orderList.
//It has methods to take orders, execute buying and renting product operations.
public class Invoker {
    private List<Product> orderList = new ArrayList<>();

    public void takeOrder(Product order){
        orderList.add(order);
    }

    //Goes through each Product object in orderList and executes a buy operation using the BuyProductCommand.
    //After executing all buy operations, it clears the orderList.
    public void placeOrders(){
        BuyProductCommand buyProductCommand = BuyProductCommand.getInstance();
        for (Product order : orderList) {
            System.out.println(buyProductCommand.setProduct(order)
                    .execute());
        }
        orderList.clear();
    }

    //Overload. It takes a list of Product, adds all products from this list to the orderList,
    //and then calls the placeOrders() method to execute buy operations.
    public void placeOrders(List<Product> productList){
        for (Product p : productList) {
            orderList.add(p);
        }
        placeOrders();
    }


    //Similar to placeOrders but uses 'RentProductCommand'
    public void rentOrders(){
        RentProductCommand rentProductCommand = RentProductCommand.getInstance();
        for (Product order : orderList) {
            System.out.println(rentProductCommand.setProduct(order)
                    .execute());
        }
        orderList.clear();
    }

    public void rentOrders(List<Product> productList){
        for (Product p : productList) {
            orderList.add(p);
        }
        rentOrders();
    }

    //Getter and setter for orderList
    public List<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Product> orderList) {
        this.orderList = orderList;
    }
}
