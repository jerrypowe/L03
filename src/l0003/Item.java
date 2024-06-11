package l0003;
public class Item {
    private String name;
    private String Origin;
    private int id;
    private int price;
    private int quantity;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrigin() {
        return Origin;
    }
    public void setOrigin(String Origin) {
        Origin = Origin;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Item() {
    }
    public Item(String name, String Origin, int id, int price, int quantity) {
        this.name = name;
        this.Origin = Origin;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }



    
}


