package l0003;
import java.util.ArrayList;

import io.MyLib;

public class ManagementCustomer {
    ArrayList<Item> listItem = new ArrayList<Item>();
    ArrayList<Customer> listCustomer = new ArrayList<Customer>();
    private int totalAmount = 0;




      public ManagementCustomer() {
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void initializeItems() {
        this.listItem.add(new Item("Coconut","Vietnam",101, 2, 100));
        this.listItem.add(new Item("Orange","US",102, 3, 100));
        this.listItem.add(new Item("Apple","Thailand",103, 4, 100));
        this.listItem.add(new Item("Grape","France",104, 6, 100));
        this.listItem.add(new Item("Mango","Vietnam",105, 2, 100));  
    }
    
    public void displayMenu() {
        System.out.println("   FRUIT-SHOP-SYSTEM");
        System.out.println("1. Create fruit.");
        System.out.println("2. Viewing. ");
        System.out.println("3. Shopping.");
        System.out.println("4. Exit.");
    }
    public void createItem(){
        String name, origin;
        int  price;
        int id;
        int quantity;
        do{
            boolean isExists = false;
            id  = MyLib.getInteger("Enter the ID of item: ","Please enter a number from 1 to 1000!!!",0,1000,"!=");
            name = MyLib.getString("Enter the name of item: ", "Please enter a text!");
            origin = MyLib.getString("Enter the origin of item: ", "Please enter a text!");
            price = MyLib.getInteger("Enter the price of item: ", "Please enter a positive number!", 0, ">");
            quantity = MyLib.getInteger("Enter quantity of item: ", "Please enter a positive number!", 0, ">");
            for (Item item : listItem){
                if(item.getId() == id || ( item.getName().equals(name)&& item.getOrigin().equals(origin))){
                    isExists = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    break;
                }
            }
            
        if (!isExists) {
            this.listItem.add(new Item(name, origin, id,price, quantity));
            break;
        }
    }while(true);
    }

    
    public void Viewing(){
        if(!listCustomer.isEmpty() && listCustomer.size() != 0){
           for(Customer customer : listCustomer){
            System.out.printf("Customer: %30s ID: %30d  ", customer.getId(), customer.getId());
            customer.displayBill();
           }

        }else{
            System.out.println("Don't have any customers available");
        }
    }


    public void displayMenuItems(){
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
        
        System.out.printf("|%3d|%3d|%-20s|%-15s|%11d$|%8d|\n", i++, item.getId(), item.getName(), item.getOrigin(), item.getPrice(), item.getQuantity());
    }

    System.out.println("+---+---+--------------------+---------------+------------+--------+");
    System.out.println();
    System.out.println(); 
    }

    public void Shopping(){
    Customer cus = new Customer();
    boolean isOke = false;
    
    do { 
         boolean isOk = false;
        do {  
            int selectedIndex = MyLib.getInteger("Your selected: ", "Please enter number from 1 to ", 1, listItem.size(), "=", this.listItem.size(), "!!!");
            Item selectedItem = this.listItem.get(selectedIndex - 1);
            int quantity = MyLib.getInteger("Please input quantity: ", "Please enter a positive number!!!", 0, ">");
            boolean isExists = false;
            for(Item item : cus.getBill()){
                if(item.getId()== selectedItem.getId()){
                item.setQuantity(item.getQuantity()+quantity);
                isOk = true;
                isExists = true;
                break;
                }
                if(isExists){
                    item.setName(this.listItem.get(selectedIndex-1).getName());
                    item.setQuantity(quantity);
                    item.setOrigin(this.listItem.get(selectedIndex-1).getOrigin());
                    item.setId(this.listItem.get(selectedIndex-1).getId());
                    cus.getBill().add(item);
                    isOk = true;
                    break;
                }
            }
            
            if(isExists) {
              Item newItem = new Item();
              newItem.setName( this.listItem.get(selectedIndex-1).getName());
              newItem.setOrigin(this.listItem.get(selectedIndex-1).getOrigin());
              newItem.setId( this.listItem.get(selectedIndex-1).getId());
              newItem.setQuantity(quantity);
              isOk = true;
              break;
            }
         isOk = true;
              break;
        } while (isOk==false);

        String opinion = MyLib.getString("Do you want to order now (Y/N)?", "Accept 'Y' or 'N' only!!!", "^[Y|y|N|n]{1}$");
            opinion.toLowerCase();
            if (opinion.equals("y")) {
                isOke = true;
                displayMenuItems(); // Display the menu again
            } else {
                isOke = false;
                displayMenuItems(); // Display the menu again
            }

    } while (isOke==false);
    cus.setId(listCustomer.size()+1);
    listCustomer.add(cus);
}



       

    

    /**
     * Executes the main functionality of the fruit shop system.
     */
    public void execute() {
        boolean isOk = false;
        initializeItems();
        do {
            displayMenu();

            int choice = MyLib.getInteger("Enter your choice: ", "Please enter number from 1 to 4");
            switch (choice) {
                case 1: {
                    // Create a new item (fruit)

                    createItem();
                    displayMenuItems();
                    break;
                }

                case 2: {
                    // Display the bills of all customers
                    if (listCustomer.isEmpty()) {
                        System.out.println("There are not any customers in the list. Please enter customer information first!");
                    } else {
                        for (int i = 0; i < listCustomer.size(); i++) {
                            System.out.printf("CUSTOMER: %-20s ID: %-30s\n", listCustomer.get(i).getName(), listCustomer.get(i));
                            
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
                    System.out.println("Please choose 1 to 4!!!");
                }
            }
        } while (!isOk);
    }
}
