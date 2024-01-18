public class Order {
    private Integer id;
    private OrderType orderType;
    private double price;
    private int quantity;

    public Order(Integer id, OrderType order, double price, int quantity) {
        this.id = id;
        this.orderType = order;
        this.price = price;
        this.quantity = quantity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Id: " +id + "\t" + "Order: " + orderType + "\t" + "Price: " + price + "\t\t" + "Quantity: " + quantity;
    }
}
