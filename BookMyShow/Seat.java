package BookMyShow;

public class Seat {
    int seat_no;
    SeatCategory seatCategory;
    boolean isOccupied;

    public Seat(int seat_no, SeatCategory seatCategory) {
        this.seat_no = seat_no;
        this.seatCategory = seatCategory;
        this.isOccupied = false;
    }
}