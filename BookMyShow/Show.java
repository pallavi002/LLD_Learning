package BookMyShow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    int show_id;
    Movie movie;
    Screen screen;
    int price;

    private final Set<Integer> bookedSeats = new HashSet<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Show(int show_id, Movie movie, Screen screen, int price) {
        this.show_id = show_id;
        this.movie = movie;
        this.screen = screen;
        this.price = price;
    }

    public boolean bookSeats(List<Integer> seats) {
        lock.lock();

        try {
            for(Integer seat : seats) {
                if(bookedSeats.contains(seat)) {
                    return false;
                }
            }
            for(Integer seat : seats) {
                bookedSeats.add(seat);
            }
            return true;
        } finally {
            lock.unlock();
        }
    }
}