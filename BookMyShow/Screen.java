package BookMyShow;
import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seats;

    public Screen(int id) {
        this.id = id;
        this.seats = new ArrayList<>();
    }

    void addSeat(Seat seat) {
        seats.add(seat);
    }
}