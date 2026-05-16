// Problem: client is tightly coupled to the messy legacy API signature
public class BadExerciseThree {
    public static void main(String[] args) {
        LegacyOrderProcessor processor = new LegacyOrderProcessor();
        processor.processOrder("carol@example.com", "TABLET", 350.00, "789 Pine Rd");
    }
}
