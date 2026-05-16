public class GoodExample {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        boolean ok = facade.placeOrder("alice@example.com", "LAPTOP", 999.99, "123 Main St");
        System.out.println("Order placed: " + ok);
    }
}
