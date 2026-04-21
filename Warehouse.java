import java.util.*;

public class Warehouse {
    private Inventory inventory;
    private Scanner scanner;
    
    
    public Warehouse() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }
    
    
    private void displayMenu() {
        System.out.println("\n===== WAREHOUSE INVENTORY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add New Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Update Item Quantity");
        System.out.println("4. Search Items");
        System.out.println("5. Display All Items");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }
    
   
    private void addItem() {
        System.out.println("\n--- ADD NEW ITEM ---");
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Quantity: ");
        int quantity = 0;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0) {
                System.out.println("Error: Quantity cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity input!");
            return;
        }
        
        System.out.print("Enter Price: ");
        double price = 0;
        try {
            price = Double.parseDouble(scanner.nextLine());
            if (price < 0) {
                System.out.println("Error: Price cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid price input!");
            return;
        }
        
        Item newItem = new Item(id, name, quantity, price);
        inventory.addItem(newItem);
    }
    
  
    private void removeItem() {
        System.out.println("\n--- REMOVE ITEM ---");
        System.out.print("Enter Item ID to remove: ");
        String id = scanner.nextLine();
        inventory.removeItem(id);
    }
    
   
    private void updateQuantity() {
        System.out.println("\n--- UPDATE ITEM QUANTITY ---");
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter New Quantity: ");
        int newQuantity = 0;
        try {
            newQuantity = Integer.parseInt(scanner.nextLine());
            if (newQuantity < 0) {
                System.out.println("Error: Quantity cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity input!");
            return;
        }
        
        inventory.updateQuantity(id, newQuantity);
    }
    
   
    private void searchItems() {
        System.out.println("\n--- SEARCH ITEMS ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Enter search type (1-2): ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                System.out.print("Enter Item ID: ");
                String id = scanner.nextLine();
                Item item = inventory.searchById(id);
                if (item != null) {
                    System.out.println("\nItem Found:");
                    System.out.println(item);
                } else {
                    System.out.println("Item not found!");
                }
                break;
                
            case "2":
                System.out.print("Enter Item Name (or partial name): ");
                String name = scanner.nextLine();
                ArrayList<Item> foundItems = inventory.searchByName(name);
                if (!foundItems.isEmpty()) {
                    System.out.println("\nFound " + foundItems.size() + " item(s):");
                    for (Item i : foundItems) {
                        System.out.println(i);
                    }
                } else {
                    System.out.println("No items found with that name!");
                }
                break;
                
            default:
                System.out.println("Invalid search type!");
        }
    }
    
   
    private void displayAllItems() {
        inventory.displayAllItems();
    }
    
    
    public void run() {
        System.out.println("Welcome to Warehouse Inventory Management System!");
        
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addItem();
                    break;
                    
                case "2":
                    removeItem();
                    break;
                    
                case "3":
                    updateQuantity();
                    break;
                    
                case "4":
                    searchItems();
                    break;
                    
                case "5":
                    displayAllItems();
                    break;
                    
                case "6":
                    System.out.println("\nThank you for using Warehouse Inventory System!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
    
    
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.run();
    }
}