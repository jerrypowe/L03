package l0003;

import java.util.ArrayList;

import io.MyLib;

/**
 * L03 - FRUIT SHOP
 *
 * @author TUPTCE181028
 */
public class ManagementCustomer {

    ArrayList<Item> listItem = new ArrayList<Item>();
    ArrayList<Item> listAvailableItem = new ArrayList<>();
    ArrayList<Customer> listCustomer = new ArrayList<Customer>();
    private int totalAmount = 0;

    /**
     * Constructs a default ManagementCustomer object.
     */
    public ManagementCustomer() {
    }

    /**
     * Returns the list of items (fruits) in the shop.
     *
     * @return the list of items (fruits) in the shop
     */
    public ArrayList<Item> getListItem() {
        return listItem;
    }

    /**
     * Sets the list of items (fruits) in the shop.
     *
     * @param listItem the list of items (fruits) in the shop
     */
    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    /**
     * Returns the list of customers.
     *
     * @return the list of customers
     */
    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    /**
     * Sets the list of customers.
     *
     * @param listCustomer the list of customers
     */
    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    /**
     * Returns the total amount of the customer' orders.
     *
     * @return the total amount of the customer' orders
     */
    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount of the customer' orders.
     *
     * @param totalAmount the total amount of the customer' orders
     */
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Initializes the list of items (fruits) in the shop.
     */
    public void initializeItems() {
        this.listAvailableItem.add(new Item("Coconut", "VN", 101, 2, 100));
        this.listAvailableItem.add(new Item("Orange", "US", 102, 3, 100));
        this.listAvailableItem.add(new Item("Apple", "THAILAND", 103, 4, 100));
        this.listAvailableItem.add(new Item("Grape", "FRANCE", 104, 6, 100));
        this.listAvailableItem.add(new Item("Mango", "VN", 105, 2, 100));
    }

    /**
     *
     */
    public void createCurrentList() {
        for (Item item : this.listAvailableItem) {
            if (item.CheckItem() == true) {
                this.listItem.add(item);
            } else {
                this.listItem.remove(item);
            }
        }
    }
     /**
     * Method to capitalize the first letter of each word in a name
     *
     * @param name the name to be capitalized
     * @return the capitalized name
     */
    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        String[] nameParts = name.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (String part : nameParts) {
            if (!part.isEmpty()) {
                result.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1).toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }

    /**
     * Displays the main menu of the fruit shop system.
     */
    public void displayMenu() {
        System.out.println("   FRUIT-SHOP-SYSTEM");
        System.out.println("1. Create fruit.");
        System.out.println("2. Viewing. ");
        System.out.println("3. Shopping.");
        System.out.println("4. Exit.");
    }

    /**
     * Creates a new item (fruit) in the shop.
     */
    public void createItem() {
        String name, origin;
        int price;
        int id;
        int quantity;
        boolean isOk = false;

        do {
            boolean isExists = false;
//            this.listItem.clear();
//            createCurrentList();
            displayMenuItemsForCreating();

            id = MyLib.getInteger("Enter the ID of new item: ", "Please enter a number from 1 to 999!!!", 0, 1000, "!=");
            for (int j = 0; j < listAvailableItem.size(); j++) {
                if (this.listAvailableItem.get(j).getId() == id) {
                    System.out.println("This Item is available in list!");

                    if (checkStore() == true) {
                        String opinion = MyLib.getString("Do you want to add quantity for this items (Y/N)?", "Accept 'Y' or 'N' only!!!", "^[Y|y|N|n]{1}$");
                        opinion.toLowerCase();
                        if (opinion.equals("y")) {
                            quantity = MyLib.getInteger("Enter quantity of item: ", "Please enter a positive number!", 0, ">");
                            this.listAvailableItem.get(j).setQuantity(this.listAvailableItem.get(j).getQuantity() + quantity);
                            System.out.println("Update successful!!!");
                            isExists = true;
                            isOk = true;
                            break;
                        } else {
                            isExists = true;
                            isOk = true;
                            break;
                        }
                    }
                }
            }
            if (isExists == false) {
                name = MyLib.getString("Enter the name of new item: ", "Please enter a text!");
                origin = MyLib.getString("Enter the origin of new item: ", "Please enter a text!");
                boolean isExists2 = false;
                int a = 0;
                for (int j = 0; j < this.listAvailableItem.size(); j++) {
                    if (this.listAvailableItem.get(j).getName().toUpperCase().equals(name.toUpperCase()) && this.listAvailableItem.get(j).getOrigin().toUpperCase().equals(origin.toUpperCase())) {
                        System.out.println("This Item is available in list!");
                        isExists2 = true;
                        a = j;
                    }

                }
                if (isExists2 == true) {
                    if (checkStore() == true) {
                        String opinion = MyLib.getString("Do you want to add quantity for this items (Y/N)?", "Accept 'Y' or 'N' only!!!", "^[Y|y|N|n]{1}$");
                        opinion.toLowerCase();
                        if (opinion.equals("y")) {
                            quantity = MyLib.getInteger("Enter quantity of item: ", "Please enter a positive number!", 0, ">");
                            this.listAvailableItem.get(a).setQuantity(this.listAvailableItem.get(a).getQuantity() + quantity);
                            System.out.println("Update successful!!!");
                            isOk = true;
                            break;
                        } else {
                            isExists = true;
                            isOk = true;
                            break;
                        }
                    }
                } else {
                    price = MyLib.getInteger("Enter the price of new item: ", "Please enter a positive number!", 0, ">");
                    quantity = MyLib.getInteger("Enter quantity of new item: ", "Please enter a positive number!", 0, ">");

                    System.out.println("Create successfull!!");
//                        this.listItem.add(new Item(name, origin, id, price, quantity));
                    this.listAvailableItem.add(new Item(capitalizeFirstLetter(name), origin.toUpperCase(), id, price, quantity));
                    isOk = true;
                    break;
                }
            }

        } while (isOk == false);
    }

    /**
     * Displays the bills of all customers.
     */
    public void Viewing() {
        if (!listCustomer.isEmpty() && listCustomer.size() != 0) {
            for (Customer customer : listCustomer) {
                System.out.printf("Customer: %30s ID: %30d  ", customer.getName(), customer.getId());
                customer.displayBill();
            }
        } else {
            System.out.println("Don't have any customers available");
        }
    }

    /**
     * Displays the menu of items (fruits) available in the shop.
     */
    public void displayMenuItems() {
        this.listItem.clear();
        createCurrentList();
        String str1 = "No.";
        String str2 = "ID";
        String str3 = "FRUIT NAME";
        String str4 = "ORIGIN";
        String str5 = "PRICE";
        String str6 = "QUANTITY";
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        System.out.printf("|%-3s|%-3s|%-20s|%-15s|%-12s|%-8s|\n", str1, str2, str3, str4, str5, str6);
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        int i = 1;
        for (Item item : this.listItem) {
            if (item.CheckItem() == true) {
                System.out.printf("|%3d|%3d|%-20s|%-15s|%12s|%8d|\n", i++, item.getId(), item.getName(), item.getOrigin(), ("$" + String.format("%d", item.getPrice())), item.getQuantity());
            }
        }
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        System.out.println();
        System.out.println();
    }

    /**
     * Displays the menu of items (fruits) available in the shop.
     */
    public void displayMenuItemsForCreating() {
        String str1 = "No.";
        String str2 = "ID";
        String str3 = "FRUIT NAME";
        String str4 = "ORIGIN";
        String str5 = "PRICE";
        String str6 = "QUANTITY";
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        System.out.printf("|%-3s|%-3s|%-20s|%-15s|%-12s|%-8s|\n", str1, str2, str3, str4, str5, str6);
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        int i = 1;
        for (Item item : this.listAvailableItem) {

            System.out.printf("|%3d|%3d|%-20s|%-15s|%12s|%8d|\n", i++, item.getId(), item.getName(), item.getOrigin(), ("$" + String.format("%d", item.getPrice())), item.getQuantity());

        }
        System.out.println("+---+---+--------------------+---------------+------------+--------+");
        System.out.println();
        System.out.println();
    }

    /**
     * Allows customers to shop and place orders.
     */
    public void Shopping() {
        Customer cus = new Customer();
        boolean isOke = false;
        ArrayList<Item> newListItem = new ArrayList<>();

        // Check if there are any items available in the store
        if (checkStore() == true) {
            do {
                if (checkStore() == true) {
                    boolean isOk = false;
                    do {

                        // Prompt the user to select an item from the menu
                        int selectedIndex = MyLib.getInteger("Your selected: ", "Please enter number from 1 to ", 1, listItem.size(), "=", this.listItem.size(), "!!!");
                        Item selectedItem = this.listItem.get(selectedIndex - 1);
                        System.out.printf("You Selected %s with ID: %d \n", selectedItem.getName(), selectedItem.getId());

                        // Prompt the user to enter the quantity of the selected item
                        int quantity = MyLib.getInteger("Please input quantity: ", "Please enter a positive number!!!", 0, ">");
                        boolean isExists = false;

                        // Check if the requested quantity is available
                        if (quantity <= this.listItem.get(selectedIndex - 1).getQuantity()) {
                            // Check if the selected item is already in the customer's cart
                            for (int i = 0; i < newListItem.size(); i++) {
                                if (newListItem.get(i).getId() == selectedItem.getId() && newListItem.get(i).getName().equals(selectedItem.getName())) {
                                    // Update the quantity of the existing item in the cart
                                    newListItem.get(i).setQuantity(newListItem.get(i).getQuantity() + quantity);
                                    this.listItem.get(selectedIndex - 1).setQuantity(this.listItem.get(selectedIndex - 1).getQuantity() - quantity);
                                    isOk = true;
                                    isExists = true;
                                    break;
                                }
                            }

                            // If the item is not in the cart yet, add a new item to the cart
                            if (isExists == false) {
                                Item newItem = new Item();
                                newItem.setName(this.listItem.get(selectedIndex - 1).getName());
                                newItem.setOrigin(this.listItem.get(selectedIndex - 1).getOrigin());
                                newItem.setId(this.listItem.get(selectedIndex - 1).getId());
                                newItem.setPrice(this.listItem.get(selectedIndex - 1).getPrice());
                                newItem.setQuantity(quantity);
                                this.listItem.get(selectedIndex - 1).setQuantity(this.listItem.get(selectedIndex - 1).getQuantity() - quantity);
                                newListItem.add(newItem);
                                isOk = true;
                                break;
                            }
                        } else if (quantity > this.listItem.get(selectedIndex - 1).getQuantity()) {
                            // Inform the user if the requested quantity is not available
                            System.out.printf("Quantity of this item is not enough for you! Quantity of %s is: %d \n", this.listItem.get(selectedIndex - 1).getName(), this.listItem.get(selectedIndex - 1).getQuantity());
                        } else if (this.listItem.get(selectedIndex - 1).getQuantity() == 0) {
                            // Inform the user if the item is sold out
                            System.out.println("This Item is sold out!! Please choice another item!!!");
                        }

                    } while (isOk == false);

                    // Ask the user if they want to place the order
                    if (checkStore() == true) {
                        String opinion = MyLib.getString("Do you want to order now (Y/N)?", "Accept 'Y' or 'N' only!!!", "^[Y|y|N|n]{1}$");
                        opinion.toLowerCase();
                        if (opinion.equals("y")) {
                            isOke = true;
                        } else {
                            isOke = false;

                            displayMenuItems(); // Display the menu again
                        }
                    }
                } else {
                    isOke = true;
                }
            } while (isOke == false);

            // Create a new customer, set their order, and add them to the customer list
            cus.setBill(newListItem);
            cus.setName(MyLib.getString("Enter customer name: ", "Please enter a name: "));
            cus.setId(listCustomer.size() + 1);
            listCustomer.add(cus);
            cus.displayBill();
        } else {
            // Inform the user if the store is sold out
            System.out.println("All items in Store is sold out!");
        }
    }

    /**
     * Checks if there are any available items in the store.
     *
     * @return true if there are items available, false otherwise
     */
    public boolean checkStore() {
        int count = 0;
        // Loop through all the items in the store
        for (Item item : this.listItem) {
            // Increment the count if the item's quantity is 0 (sold out)
            if (item.getQuantity() == 0) {
                count++;
            }
        }

        // If the count is equal to the size of the listItem, it means all items are sold out
        if (count == this.listItem.size()) {
            return false;
        }
        return true;
    }

    /**
     * Executes the main functionality of the fruit shop system.
     */
    public void execute() {
        boolean isOk = false;
        initializeItems(); // Initialize the list of items in the store

        do {
            // Display the main menu
            displayMenu();

            // Prompt the user to enter a choice
            int choice = MyLib.getInteger("Enter your choice: ", "Please enter number from 1 to 4");
            switch (choice) {
                case 1: {
                    // Create a new item (fruit)
                    createItem();
                    displayMenuItemsForCreating();
                    break;
                }

                case 2: {
                    // Display the bills of all customers
                    if (listCustomer.isEmpty()) {
                        System.out.println("There are not any customers in the list. Please enter customer information first!");
                    } else {
                        // Loop through all the customers and display their bills
                        for (int i = 0; i < listCustomer.size(); i++) {
                            System.out.printf("CUSTOMER: %-20s ID: %-30s\n", listCustomer.get(i).getName(), listCustomer.get(i).getId());
                            listCustomer.get(i).displayBill();
                            System.out.println();
                        }
                    }
                    break;
                }

                case 3: {
                    // Create a new customer and allow them to place an order

                    displayMenuItems();
                    Shopping();
                    break;
                }

                case 4: {
                    // Exit the system
                    System.exit(0);
                    break;
                }
                default: {
                    // Handle invalid user input
                    System.out.println("Please choose 1 to 4!!!");
                }
            }
        } while (!isOk);
    }
}
