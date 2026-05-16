public class CheckoutFacade {
    private final Inventory     inventory = new Inventory();
    private final Payment       payment   = new Payment();
    private final Shipping      shipping  = new Shipping();
    private final Email         email     = new Email();
    private final TaxCalculator tax       = new TaxCalculator();
    private final Logger        logger    = new Logger();

    public OrderResult checkout(String userId, String productId,
                                double price, String address, String state) {
        if (!inventory.checkStock(productId)) {
            logger.log(userId, false);
            return new OrderResult(false, null, "Out of stock: " + productId);
        }

        double taxAmount = tax.calculate(price, state);
        double total     = price + taxAmount;

        if (!payment.charge(userId, total)) {
            logger.log(userId, false);
            return new OrderResult(false, null, "Payment failed");
        }

        inventory.reserve(productId);

        if (!shipping.isAvailable()) {
            payment.refund(userId, total);
            inventory.release(productId);
            logger.log(userId, false);
            return new OrderResult(false, null, "Shipping unavailable — rolled back");
        }

        String label = shipping.createLabel(address);
        shipping.schedulePickup(label);

        String body = String.format(
            "Order confirmed. Total: £%.2f (incl. £%.2f tax). Tracking: %s",
            total, taxAmount, label);
        email.send(userId, "Order Confirmed", body);

        logger.log(userId, true);
        return new OrderResult(true, label, "Order placed successfully");
    }
}
