package examples;

public class Product {
    private String productName;
    private double price;
    private int stockQuantity;

    public Product(String name, double price, int stock){
        this.productName = name;
        this.price = price;
        this.stockQuantity = stock;
    }

    void displayInfo(){
        System.out.printf("Name: %s%nPrice: %f%nStack Quantity: %d%n", productName, price, stockQuantity);
    }

    Boolean isAvilable(int quantity){
        if(quantity>0)
            return true;
        else 
            return false;
    }
}

class mainClass{
    public static void main(String[] arg){
        Product product1 = new Product("elma", 5, 10);
        Product product2 = new Product("armut", 6, 0);

        product1.displayInfo();
        product2.displayInfo();


    }
}