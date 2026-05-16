// 3 reasons this needs a facade:
//   1. Tight coupling — client knows RoomService, PaymentService, LoyaltyPoints, EmailService
//   2. Complex client code — nested conditionals duplicated everywhere bookings happen
//   3. Hard to test — need to mock 4 subsystems just to test one booking
public class BadExerciseOne {
    public static void main(String[] args) {
        RoomService    rooms   = new RoomService();
        PaymentService payment = new PaymentService();
        LoyaltyPoints  loyalty = new LoyaltyPoints();
        EmailService   email   = new EmailService();

        String guest    = "john@example.com";
        String roomType = "DELUXE";
        double price    = 250.00;

        if (rooms.isAvailable(roomType)) {
            if (payment.charge(guest, price)) {
                rooms.book(roomType, guest);
                loyalty.addPoints(guest, (int) price);
                email.sendConfirmation(guest, roomType);
                System.out.println("Booking confirmed");
            } else {
                System.out.println("Payment declined");
            }
        } else {
            System.out.println("Room not available");
        }
    }
}
