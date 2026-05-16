public class GoodExerciseOne {
    public static void main(String[] args) {
        BookingFacade booking = new BookingFacade();
        boolean ok = booking.bookRoom("john@example.com", "DELUXE", 250.00);
        System.out.println("Booking result: " + ok);
    }
}
