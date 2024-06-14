package l0003;

import java.util.ArrayList;

/**
 * L03 - FRUIT SHOP
 *
 * @author TUPTCE181028
 */
public class Customer {

    private String Name;
    private int id;
    private ArrayList<Item> Bill = new ArrayList<Item>();
    private int totalAmount = 0;

    /**
     * Returns the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the name of the customer
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Returns the bill (list of items) of the customer.
     *
     * @return the bill (list of items) of the customer
     */
    public ArrayList<Item> getBill() {
        return Bill;
    }

    /**
     * Sets the bill (list of items) of the customer.
     *
     * @param bill the bill (list of items) of the customer
     */
    public void setBill(ArrayList<Item> bill) {
        Bill = bill;
    }

    /**
     * Constructs a default Customer object.
     */
    public Customer() {
    }

    /**
     * Constructs a Customer object with the given name and bill.
     *
     * @param name the name of the customer
     * @param bill the bill (list of items) of the customer
     */
    public Customer(String name, ArrayList<Item> bill) {
        Name = name;
        Bill = bill;
    }

    /**
     * Returns the ID of the customer.
     *
     * @return the ID of the customer
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id the ID of the customer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Calculates the total amount of the customer's order.
     */
    public void calculateTotalAmount() {
        totalAmount = 0;
        for (Item item : Bill) {
            totalAmount += item.getQuantity() * item.getPrice();
        }
    }

    /**
     * Displays the customer's bill, including the items, quantities, prices,
     * and the total amount.
     */
    public void displayBill() {
        calculateTotalAmount();
        String str1 = "No.";
        String str5 = "ID";
        String str2 = "FRUIT NAME";
        String str3 = "QUANTINY";
        String str4 = "PRICE";
        String str6 = "AMOUNT";

        System.out.println("+---+---+---------------+---------------+---------------+---------------+");
        System.out.printf("|%-3s|%-3s|%-15s|%-15s|%-15s|%-15s|\n", str1, str5, str2, str3, str4, str6);
        System.out.println("+---+---+---------------+---------------+---------------+---------------+");

        int i = 1;
        for (Item item : this.Bill) {
            int amount = item.getPrice() * item.getQuantity();
            System.out.printf("|%3d|%3d|%-15s|%15d|%15s|%15s|\n", i++, item.getId(), item.getName(), item.getQuantity(), ("$" + String.format("%d", item.getPrice())), ("$" + String.format("%d", amount)));
        }

        System.out.println("+---+---+---------------+---------------+---------------+---------------+");
        String Str = "TOTAL:";
        System.out.printf("|%-55s|%15s|\n", Str, ("$" + String.format("%,d", totalAmount)));
        System.out.println("+---+---+---------------+---------------+---------------+---------------+");
    }
}
