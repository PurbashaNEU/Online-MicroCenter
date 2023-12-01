package com.neu;

import com.neu.adapter_pattern.Manufacturer;
import com.neu.adapter_pattern.ManufacturerObjectAdapter;
import com.neu.builder_pattern.ProductBuilder;
import com.neu.factory_pattern.EmployeeFactory;
import com.neu.builder_pattern.EmployeeBuilder;
import com.neu.command_pattern.Invoker;
import com.neu.facade_pattern.DeliveryType;
import com.neu.facade_pattern.OrderFacade;
import com.neu.factory_pattern.ProductFactory;
import com.neu.observer_pattern.Order;
import com.neu.state_pattern.*;
import com.neu.strategy_pattern.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements StoreStateAPI {

    private String name;
    private List<Product> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String FILE_NAME = "csye7374/src/main/java/com/neu/_data/ProductDetails.txt";

    private StoreStateAPI openState = new OpenState(this);
    private StoreStateAPI stockState = new StockState(this);
    private StoreStateAPI closeState = new CloseState(this);
    private StoreStateAPI state;


    private static Map<DiscountStrategy,DiscountStrategyAPI> algorithmMap = new HashMap<>();
    {
        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
    }

    public Store(String name) {
        super();
        this.name = name;
        this.state = getOpenState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void setItemList(List<Product> itemList) {
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public static DiscountStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public static void setUsingStrategy(DiscountStrategy usingStrategy) {
        Store.usingStrategy = usingStrategy;
    }

    public static Map<DiscountStrategy, DiscountStrategyAPI> getAlgorithmMap() {
        return algorithmMap;
    }

    public static void setAlgorithmMap(Map<DiscountStrategy, DiscountStrategyAPI> algorithmMap) {
        Store.algorithmMap = algorithmMap;
    }

    public StoreStateAPI getState() {
        return state;
    }

    public void setState(StoreStateAPI state) {
        this.state = state;
    }

    public StoreStateAPI getOpenState() {
        return openState;
    }

    public void setOpenState(StoreStateAPI openState) {
        this.openState = openState;
    }

    public StoreStateAPI getStockState() {
        return stockState;
    }

    public void setStockState(StoreStateAPI stockState) {
        this.stockState = stockState;
    }

    public StoreStateAPI getCloseState() {
        return closeState;
    }

    public void setCloseState(StoreStateAPI closeState) {
        this.closeState = closeState;
    }

    @Override
    public void state_Open() {
        this.state.state_Open();

    }

    @Override
    public void state_Close() {
        this.state.state_Close();
    }

    @Override
    public void state_Stock() {
        this.state.state_Stock();
    }

    public static void demo() {

        FileUtility.getFileData(FILE_NAME);

        List<Product> productList = new ArrayList<>();

        //Builder Pattern and getting object of Builder using Factory and Singleton Pattern
        System.out.println("***************************************************************************************");
        System.out.println("Exhibiting the practical implementation of the Builder design pattern: Delegating the task of constructing instances of Product objects to the Product Builder. This Builder entity incorporates the build method, streamlining the creation of product representations");
        System.out.println("Utilizing the factory and singleton design patterns for the purpose of getting a single instance of the Product Builder object");
        ProductBuilder productBuilder = new ProductBuilder(1, "Iphone 14 Pro", 10, ProductCategory.Cellphone, "Apple");
        ProductAPI product = ProductFactory.getInstance().getObject(productBuilder);
        productList.add((Product) product);
        System.out.println(product);
        FileUtility.appendEntryToFile(FILE_NAME, productBuilder);

        //Prototype Pattern to clone the object of manufacturer
        System.out.println("***************************************************************************************");
        System.out.println("Illustration of prototype pattern to clone the Manufacturer object");
        Manufacturer manufacturer = Manufacturer.getInstance().clone();
        manufacturer.setManufacturerName("Philips")
                .setAge(52)
                .setNoOfProductsManufacturerd(10);

        //Adapter Pattern to adapt manufacturer legacy code with Product Interface
        ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(product, manufacturer);

        System.out.println(product);
        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating the utilization of the Adapter pattern to adapt Manufacturer class with the Product Interface, followed by printing their respective instances");

        System.out.println(manufacturerAdapter);
        System.out.println("***************************************************************************************");

        //Demonstration of facade pattern and decorator pattern to decorate the product object
        System.out.println("Illustrating the implementation of the Facade design pattern alongwith decorator pattern which is used to decorate products and which are then subsequently added to our list of order");
        System.out.println("Illustrating the implementation of the Observer design pattern to update the cost of shipping and discount as the order count changes in the order list");

        OrderFacade orderFacade = new OrderFacade(product);
        Order order = orderFacade.order();

        System.out.println(order);
        order.setDeliveryType(DeliveryType.HOME_DELIVERY);

        productBuilder = new ProductBuilder(2, "XPS 13", 100, ProductCategory.Laptop, "Dell");
        product = ProductFactory.getInstance().getObject(productBuilder);
        order.addProduct(product);
        System.out.println(order);
        productList.add((Product) product);
        FileUtility.appendEntryToFile(FILE_NAME, productBuilder);

        productBuilder = new ProductBuilder(3, "Whoop Slim", 150, ProductCategory.SmartWatch, "Whoop");
        product = ProductFactory.getInstance().getObject(productBuilder);
        order.addProduct(product);
        System.out.println(order);
        productList.add((Product) product);
        FileUtility.appendEntryToFile(FILE_NAME, productBuilder);


        productBuilder = new ProductBuilder(4, "Mac Book 15", 101, ProductCategory.Laptop, "Apple");
        product = ProductFactory.getInstance().getObject(productBuilder);
        order.addProduct(product);
        System.out.println(order);
        productList.add((Product) product);
        FileUtility.appendEntryToFile(FILE_NAME, productBuilder);


        productBuilder = new ProductBuilder(5, "Galaxy Tab Pro 11", 200, ProductCategory.Tablet, "Samsung");
        product = ProductFactory.getInstance().getObject(productBuilder);
        order.addProduct(product);
        System.out.println(order);
        productList.add((Product) product);


        productBuilder = new ProductBuilder(6, "QLED 55", 310, ProductCategory.Television, "Samsung");
        product = ProductFactory.getInstance().getObject(productBuilder);
        order.addProduct(product);
        System.out.println(order);
        productList.add((Product) product);
        System.out.println("***************************************************************************************");

        //Command Pattern
        System.out.println("Illustrating the execution of the Command design pattern to initiate requests for the entirety of product orders, followed by the systematic printing of these orders");

        Invoker invoker = new Invoker();
        invoker.placeOrders(productList);
        invoker.rentOrders(productList);
        System.out.println("***************************************************************************************");

        Store productStore = new Store("Micro Center");
        EmployeeBuilder emplBuilder = new EmployeeBuilder(7,18,"Dan","Joe",16.2);
        Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
        System.out.println("Using the Singleton and factory design patterns to enforce the creation of a single instance of the Employee Builder object");
        System.out.println(empl);
        System.out.println("***************************************************************************************");

        //State Pattern
        System.out.println("Demonstration of state pattern completed life cycle of order transitioning from ordered to delivered state");

        order.state_Awaiting_OrderConfirmation();
        order.state_OrderConfirmed();
        order.state_OrderDelivered();
        order.state_OrderDispatched();
        order.state_OrderDelivered();
        order.state_OrderDelivered();
        System.out.println("***************************************************************************************");
        //Strategy Pattern
        System.out.println("Illustrating the state pattern's practical execution, encompassing the entire lifecycle of an order's progression from the \"ordered\" state to the final \"delivered\" state");
        System.out.println("Product before discount: \n"+ product);
        double price=0;
        for(DiscountStrategy strategy : Store.getAlgorithmMap().keySet()){
            productStore.setUsingStrategy(strategy);
            price = ((Product)product).runStrategy();
            System.out.println("Product price after discount during sale: " + strategy + price);
        }
    }
}
