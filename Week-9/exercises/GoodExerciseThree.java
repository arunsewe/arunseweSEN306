public class GoodExerciseThree {
    public static void main(String[] args) {
        LegacyOrderFacade facade = new LegacyOrderFacade();
        facade.placeOrder("carol@example.com", "TABLET", 350.00, "789 Pine Rd");
    }
}
