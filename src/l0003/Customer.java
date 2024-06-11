package l0003;
import java.util.ArrayList;

public class Customer {
 private String Name;
 private int id;
 private ArrayList<Item> Bill = new ArrayList<Item>();
 private int totalAmount = 0;
public String getName() {
    return Name;
}
public void setName(String name) {
    Name = name;
}
public ArrayList<Item> getBill() {
    return Bill;
}
public void setBill(ArrayList<Item> bill) {
    Bill = bill;
}
public Customer() {
}
public Customer(String name, ArrayList<Item> bill) {
    Name = name;
    Bill = bill;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}

 /**
     * Calculates the total amount of the customer's order.
     */
    public void calculateTotalAmount() {
        totalAmount = 0;
        int i = 1 ; 
        for (Item item : Bill) {
            totalAmount += item.getQuantity()* item.getPrice();
            i++;
        }
    }
public void displayBill() {

    calculateTotalAmount();
    String str1 = "No.";
    String str5 ="ID.";
    String str2 = "FRUIT NAME";
    String str3 = "QUANTINY";
    String str4 = "PRICE";
    System.out.println("+---+---------------+---------------+---------------+");
    System.out.printf("|%-3s|%-3s|%-15s|%-15s|%-15s|\n", str1, str2, str3, str4);
    System.out.println("+---+---------------+---------------+---------------+");
    int i = 1;
    for ( Item item : Bill) {
        System.out.printf("|%3d|%3d|%-15s|%-15d|%14.2f$|\n", i++,item.getId(),item.getName(),item.getQuantity(),item.getId());
    }
    System.out.println("+---+---------------+---------------+---------------+");
    System.out.printf("|%35s|%14.1f$|\n", "TOTAL:", totalAmount);
    System.out.println("+---+---------------+---------------+---------------+");
//        System.out.printf("CUSTOMER: %-20s ID: %-30s\n", customerName, customerID);

}
}
