package Project4;
/**
 * Represents a product available for purchase.
 * Each product has a name, price, and stock quantity.
 */
public class Product
{
    private String productName;
    private double productPrice;
    private int stockQuantity;

    public Product(String productName, double productPrice, int stockQuantity){
        if(productName == null || productPrice < 0 || stockQuantity < 0){
            throw new IllegalArgumentException("Price and stock quantity cannot be negative");
        }
        this.productName = productName;
        this.productPrice = productPrice;
        this.stockQuantity = stockQuantity;
    }

    // Getters for accessing private variables
    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity){
        if(stockQuantity < 0){
            throw new IllegalArgumentException("Invalid stock quantity.");
        }
        this.stockQuantity = stockQuantity;
    }


    @Override
    public String toString(){
        return String.format("%s - $%.2f (Stock: %d)", productName, productPrice, stockQuantity);

    }

    public boolean isAvailable(int quantity) {
        if(quantity < 0){
            System.out.println("Quantity cannot be negative");
            return false;
        }
        return quantity <= stockQuantity;
    }

    public void reduceStockQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (!isAvailable(quantity)) {
            throw new IllegalArgumentException("Insufficient stock available.");
        }
        stockQuantity -= quantity;
    }
}
