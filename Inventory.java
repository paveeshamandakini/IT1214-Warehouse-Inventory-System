import java.util.*;

public class Inventory {
    private HashMap<String, Item> items; 
    
    
    public Inventory() {
        items = new HashMap<>();
    }
    
    
    public boolean addItem(Item item) {
        if (items.containsKey(item.getItemId())) {
            System.out.println("Error: Item ID already exists!");
            return false;
        }
        items.put(item.getItemId(), item);
        System.out.println("Item added successfully!");
        return true;
    }
    
    
    public boolean removeItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            System.out.println("Item removed successfully!");
            return true;
        }
        System.out.println("Error: Item ID not found!");
        return false;
    }
    
    
    public boolean updateQuantity(String itemId, int newQuantity) {
        if (items.containsKey(itemId)) {
            Item item = items.get(itemId);
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully!");
            return true;
        }
        System.out.println("Error: Item ID not found!");
        return false;
    }
    
   
    public Item searchById(String itemId) {
        return items.get(itemId);
    }
    
    
    public ArrayList<Item> searchByName(String itemName) {
        ArrayList<Item> foundItems = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
    
    
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        
        System.out.println("\n========== INVENTORY LIST ==========");
        System.out.println("Total Items: " + items.size());
        System.out.println("-------------------------------------");
        for (Item item : items.values()) {
            System.out.println(item);
        }
        System.out.println("=====================================\n");
    }
    
    
    public int getItemCount() {
        return items.size();
    }
}