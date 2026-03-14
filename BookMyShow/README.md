Theatre -> * Screens
Theatre -> * Shows
Theatre -> addScreen()
Theatre -> addShow()

Screen -> * Seats
Screen -> addSeats()


Show -> Screen
Show -> Movie 
Show -> price, showId
Show -> bookTickets()

Seat -> Premium, Economy, isOccupied

Payment -> pay()

Booking -> bookSeats();