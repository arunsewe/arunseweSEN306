public class RoomService {
    public boolean isAvailable(String roomType) { return true; }
    public void book(String roomType, String guest) {
        System.out.println("Room booked: " + roomType + " for " + guest);
    }
}
