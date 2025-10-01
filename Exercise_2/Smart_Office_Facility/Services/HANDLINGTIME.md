
#things to be overwhelmed 

want to implement the relese of room if the booked room is not occupied in 5 min;

NOTE: 
    want to consider the room as booked only after the start time;
    
    i.e. 
        if current time is 12:30
            if room is booked at 12:40 for 20min duration;
                ->the room has to be released after 5mins from the room's book time 
                    i.e. room to release booking at 12:45 (5mins from 12:40)
            
            

secnerio: 
    if current time is 12:30 
        if room 1 is blocked at 14:15 for 25 min

            ->expectation: 
                room has to be in UNBOOKED state till 14:14, and occupant shouldn't be able to occupy the room.
            ->current logic:
                updates the room state booked on the first booking;
            
    
secnerio: 
    removal of booking after end time.

    if current time has passed the end time of the booking:
        the booking has to be removed;