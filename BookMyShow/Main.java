package BookMyShow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie(1, "Dhurandar", 150);

        Screen screen1 = new Screen(1);

        Seat seat1 = new Seat(1, SeatCategory.ECONOMY);
        Seat seat2 = new Seat(2, SeatCategory.ECONOMY);

        screen1.addSeat(seat1);
        screen1.addSeat(seat2);

        Show show = new Show(101, movie, screen1, 300);

        Thread user1 = new Thread(new Booking("user1", show, List.of(1, 2)));
        Thread user2 = new Thread(new Booking("user2", show, List.of(1, 2)));

        user1.start();
        user2.start();


    }
}
