public class ExerciseTwo {
    public static void main(String[] args) {
        System.out.println("Exercise 2 proof — same client call, new subsystems added inside facade:\n");

        CheckoutFacade facade = new CheckoutFacade();

        // Client call unchanged — TaxCalculator and Logger work silently inside the facade
        OrderResult result = facade.checkout(
            "carol@example.com", "TABLET", 300.00, "789 Pine Rd", "CA");

        System.out.println("\nResult: " + result);
        System.out.println("\nNote: tax (8% CA) and logging were added inside CheckoutFacade.");
        System.out.println("This client code was not touched.");
    }
}
