package Project4;
/**
 * Provides a menu-driven interface for the shopping application.
 * Handles user input and interactions with the Customer and ShoppingCart classes.
 */
import java.util.Scanner;
public class Menu
{
    private Scanner scanner;
    private Customer customer;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.customer=new Customer("Shristi");
    }

    /**
     * Starts the menu and handles user interactions.
     */
    public void start(){
        boolean running=true;
        while(running){
            displayMenu();
            int choice=getUserChoice();
            switch(choice){
                case 1:
                    addProductToCart();
                    break;
                case 2:
                    removeProductFromCart();
                    break;
                case 3:
                    customer.viewCart();
                    break;
                case 4:
                    customer.checkout();
                    running = false; // Exit after checkout
                    break;
                case 5:
                    running = false; // Exit without checkout
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }
    }

    //Method to display Menu
    public void displayMenu(){
        System.out.println("\n=======Welcome To Project4.Customer Project4.Menu=======");
        System.out.println("1. Add a product to the cart: ");
        System.out.println("2. Remove a product from the cart: ");
        System.out.println("3. View cart: ");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    //get the choice from user
    public int getUserChoice(){
        int choice;
        System.out.print("Enter your choice: ");
        try{
            choice=Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            choice=-1;
        }
        return choice;
    }

    //Method Add a product to the cart
    public void addProductToCart(){
        System.out.println("\nAvailable Products: ");
        Product lipstick=new Product("Lipstick",15.99,10);
        Product foundation = new Product("Foundation", 25.49, 5);
        Product eyeliner = new Product("Eyeliner", 9.99, 15);

        Product[]products={lipstick,foundation,eyeliner};
        for(int i=0;i<products.length;i++){
            System.out.println((i+1)+"."+products[i]);
        }
        System.out.println("Choose a product to add to the cart: (1-3");
        int productChoice=getUserChoice();

        if(productChoice>=1 && productChoice<=3){
            Product selectedProduct = products[productChoice - 1];
            System.out.print("Enter quantity: ");
            int quantity = getUserChoice();
            customer.getCart().addItem(selectedProduct, quantity);
        } else {
            System.out.println("Invalid product choice.");

        }
    }

    // Remove a product from the cart
    private void removeProductFromCart() {
        System.out.println("\nRemoving a product:");
        customer.viewCart();
        System.out.print("Enter the product name to remove: ");
        String productName = scanner.nextLine();

        Product productToRemove = null;
        for (Product product : customer.getCart().cartItems.keySet()) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            System.out.print("Enter quantity to remove: ");
            int quantity = getUserChoice();
            customer.getCart().removeItem(productToRemove, quantity);
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

}
