import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        OrderBook orderBook = new OrderBook();
        orderBook.add(new Order(count.incrementAndGet(), OrderType.BUY, 20, 100));
        orderBook.add(new Order(count.incrementAndGet(), OrderType.BUY, 30, 10));
        orderBook.add(new Order(count.incrementAndGet(), OrderType.BUY, 40, 50));
        orderBook.add(new Order(count.incrementAndGet(), OrderType.SELL, 50, 200));
        orderBook.printAllOrders();
        Scanner scanner = new Scanner(System.in);
        double price;
        int quantity;
        boolean end = true;
        String choice;
        while(end){

            System.out.print("What do you want to do?\nChoose the operation by writing the number and press enter\n");
            System.out.print("1 Add buy order\n2 Add sell order\n3 finalize order\n4 end program\n");
            choice = scanner.nextLine();
            System.out.println(choice);
            switch(choice) {
                case "1":

                    System.out.print("Price of an order: ");
                    price = scanner.nextDouble();
                    System.out.println();
                    System.out.print("quantity of stock: ");
                    quantity = scanner.nextInt();
                    System.out.println();
                    orderBook.add(new Order(count.incrementAndGet(), OrderType.BUY, price, quantity));
                    break;
                case "2":

                    System.out.print("Price of an order: ");
                    price = scanner.nextDouble();
                    System.out.println();
                    System.out.print("quantity of stock: ");
                    quantity = scanner.nextInt();
                    orderBook.add(new Order(count.incrementAndGet(), OrderType.SELL, price, quantity));
                    break;
                case "3":

                    System.out.print("Add id of an order: ");
                    int x = scanner.nextInt();
                    System.out.println();
                    orderBook.remove(x);
                    break;
                case "4":
                    end = false;
                    break;
                default:
                    System.out.println("Unknown operation");
            }
            orderBook.printAllOrders();
            scanner.nextLine();
        }

    }
}