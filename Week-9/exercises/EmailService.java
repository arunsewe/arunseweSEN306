public class EmailService {
    public void sendConfirmation(String guest, String roomType) {
        System.out.println("Email sent to " + guest + ": " + roomType + " confirmed.");
    }
}
