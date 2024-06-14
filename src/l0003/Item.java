package l0003;

/**
 * L03 - FRUIT SHOP
 *
 * @author TUPTCE181028
 */
public class Item {

    private String name;
    private String Origin;
    private int id;
    private int price;
    private int quantity;

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the origin of the item.
     *
     * @return the origin of the item
     */
    public String getOrigin() {
        return Origin;
    }

    /**
     * Sets the origin of the item.
     *
     * @param Origin the origin of the item
     */
    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    /**
     * Returns the ID of the item.
     *
     * @return the ID of the item
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the item.
     *
     * @param id the ID of the item
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the price of the item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Constructs a default Item object.
     */
    public Item() {
    }

    /**
     * Constructs an Item object with the given parameters.
     *
     * @param name the name of the item
     * @param Origin the origin of the item
     * @param id the ID of the item
     * @param price the price of the item
     * @param quantity the quantity of the item
     */
    public Item(String name, String Origin, int id, int price, int quantity) {
        this.name = name;
        this.Origin = Origin;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public boolean CheckItem() {
        if (this.quantity == 0) {
            return false;
        } else {
            return true;
        }
    }

}
