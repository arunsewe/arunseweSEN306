public class MainCodingExercise {
    public static void main(String[] args) {
        CheckoutFacade facade = new CheckoutFacade();

        System.out.println("-- TX (0% tax) --");
        OrderResult r1 = facade.checkout(
            "alice@example.com", "LAPTOP", 999.99, "123 Main St", "TX");
        System.out.println(r1 + "\n");

        System.out.println("-- CA (8% tax) --");
        OrderResult r2 = facade.checkout(
            "bob@example.com", "PHONE", 500.00, "456 Oak Ave", "CA");
        System.out.println(r2);
    }
}
