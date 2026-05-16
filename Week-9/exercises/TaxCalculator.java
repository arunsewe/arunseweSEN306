public class TaxCalculator {
    public double calculate(double price, String state) {
        return "CA".equalsIgnoreCase(state) ? price * 0.08 : 0.0;
    }
}
