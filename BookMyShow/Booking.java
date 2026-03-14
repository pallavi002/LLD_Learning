package BookMyShow;

import java.util.List;

public class Booking implements Runnable {
    String user;
    Show show;
    List<Integer> seats;

    public Booking(String user, Show show, List<Integer> seats) {
        this.user = user;
        this.show = show;
        this.seats = seats;
    }

    public void run() {
        if(show.bookSeats(seats)) {
            System.out.println(user + " booked seats " + seats);
        } else {
            System.out.println(user + " failed to book seats " + seats);
        }
    }
}