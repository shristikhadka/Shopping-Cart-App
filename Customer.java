package Project4;
/**
 * Represents a customer in the shopping system.
 * Each customer has a name and a shopping cart.
 */


public class Customer
{
    private String name;
    private ShoppingCart cart;

    /**
     * Constructs a Customer with the specified name and an empty shopping cart.
     * @param name the name of the customer
     * @throws IllegalArgumentException if name is null or empty
     */
    public Customer(String name){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        this.name=name;
        this.cart=new ShoppingCart();
    }

    //getters
    public String getName(){
        return name;
    }
    public ShoppingCart getCart(){
        return cart;
    }

    /**
     * Displays the contents of the customer's shopping cart.
     */
    public void viewCart(){
        cart.displayCart();
    }

    /**
     * Checks out the customer, displaying the cart contents and a thank-you message.
     * Resets the cart for the next session.
     */
    public void checkout(){
        System.out.println("Checking out..");
        cart.displayCart();
        System.out.println("Thank you for shopping with us "+getName()+"!");

    }
}
