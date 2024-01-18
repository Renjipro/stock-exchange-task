import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OrderBook {
    private List<Order> buyAndSellOrders;
    private Order bestBuyOrder;
    private Order bestSellOrder;

    public OrderBook() {
        buyAndSellOrders = new ArrayList();
    }
    public void add(Order order){
        buyAndSellOrders.add(order);
        if (bestBuyOrder == null || bestSellOrder == null){
            bestBuyOrder = order;
            bestSellOrder = order;
        }

        if (order.getOrderType().equals(OrderType.BUY))
        theBestBuyOrder(order);
        if (order.getOrderType().equals(OrderType.SELL))
        theBestSellOrder(order);

    }
    public void remove(int id){
        Optional<Order> opt = buyAndSellOrders.stream().findFirst().filter(e-> e.getId() == id);
        if(opt.isPresent()){
            buyAndSellOrders.remove(opt.get());
        }
        else{
            System.out.println("THERE IS NO ORDER WITH GIVEN ID");
            System.out.println();
        }
    }

    public void printAllOrders(){
        Stream<Order> stream = buyAndSellOrders.stream();
        stream.forEach(order -> System.out.println(order.toString()));
        System.out.println("Best buy order: " + bestBuyOrder.toString());
        System.out.println("Best sell order: " + bestSellOrder.toString());
    }

    public List getBuyAndSellOrders() {
        return buyAndSellOrders;
    }

    public void setBuyAndSellOrders(List buyAndSellOrders) {
        this.buyAndSellOrders = buyAndSellOrders;
    }

    private void theBestBuyOrder(Order order){

        if ( bestBuyOrder.getPrice() < order.getPrice()){
            bestBuyOrder = order;
        }

    }

    private void theBestSellOrder(Order order){
        if ( bestSellOrder.getPrice() > order.getPrice()){
            bestSellOrder = order;
        }
    }
}
