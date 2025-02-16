package Project4;

import java.util.HashMap;
/**
 * Manages a collection of products and their quantities in a shopping cart.
 * Provides functionality to add, remove, and display products in the cart.
 */

public class ShoppingCart
{
    HashMap<Product,Integer>cartItems;

    // Constructor
    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    public void addItem(Product product, int quantity){
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Quantity must be greater than zero.");
            return;
        }

        if (product.isAvailable(quantity)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            product.reduceStockQuantity(quantity);
            System.out.println(quantity + " " + product.getProductName() + "(s) added to the cart.");
        } else {
            System.out.println("Insufficient stock for " + product.getProductName());
        }

    }

    public void removeItem(Product product, int quantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);

            if (quantity >= currentQuantity) {
                // Remove the product entirely if quantity to remove is greater or equal
                cartItems.remove(product);
                System.out.println("Removed all " + product.getProductName() + "(s) from the cart.");
            } else {
                // Decrease the quantity in the cart
                cartItems.put(product, currentQuantity - quantity);
                System.out.println(quantity + " " + product.getProductName() + "(s) removed from the cart.");
            }
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public double calculateTotal(){
        double total = 0;
        for(Product product : cartItems.keySet()){
            total += product.getProductPrice() * cartItems.get(product);
        }
        return total;
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else {
            System.out.println("Shopping Cart Contents:");
            for (Product product : cartItems.keySet()) {
                System.out.println(product.getProductName() + " x" + cartItems.get(product));
            }
            System.out.printf("Total: $%.2f\n", calculateTotal());
        }

    }
}
