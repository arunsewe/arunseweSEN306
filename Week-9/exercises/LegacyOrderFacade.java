public class LegacyOrderFacade {
    private final LegacyOrderProcessor processor = new LegacyOrderProcessor();

    public void placeOrder(String customerEmail, String itemCode,
                           double amount, String deliveryAddress) {
        System.out.println("[LegacyOrderFacade] Delegating to legacy processor...");
        processor.processOrder(customerEmail, itemCode, amount, deliveryAddress);
    }
}
