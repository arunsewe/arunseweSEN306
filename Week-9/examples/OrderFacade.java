public class OrderFacade {
    private Inventory inventory;
    private Payment   payment;
    private Shipping  shipping;
    private Email     email;

    public OrderFacade() {
        this.inventory = new Inventory();
        this.payment   = new Payment();
        this.shipping  = new Shipping();
        this.email     = new Email();
    }

    public boolean placeOrder(String userId, String productId,
                              double price, String address) {
        if (!inventory.checkStock(productId)) return false;
        if (!payment.charge(userId, price))   return false;

        inventory.reserve(productId);
        String label = shipping.createLabel(address);
        shipping.schedulePickup(label);
        email.send(userId, "Order Confirmed", "On its way!");
        return true;
    }
}
