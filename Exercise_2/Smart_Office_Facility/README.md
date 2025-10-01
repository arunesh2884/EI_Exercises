# Smart_Office_Facility
A console-based Java application that manages a smart office environment with features such as conference room booking, occupancy detection, and automated control of air conditioning and lighting. The project demonstrates OOP principles, design patterns, and clean coding practices for building scalable, maintainable systems.


#Functional Requirements
Mandatory Requirements
1. The system should allow users to configure the office facility by specifying the number of
meeting rooms.
2. Users should be able to book and cancel bookings for conference rooms.
3. Occupancy should be detected using sensors that register when at least two people enter a
room.
4. Unoccupied rooms should automatically release bookings if not occupied within 5 minutes.
5. The air conditioning and lights should turn off if the room is not occupied.



#User Flow of the Project
1. System Initialization (Config command)
    User configures the office by specifying number of meeting rooms.
    System creates Room objects with default states (unoccupied, no booking, AC/Lights off).
        patterns: Singleton - ensure only one System object is created. 

2. Room Configuration (Config room command)
    User sets maximum capacity of rooms.
    Updates attributes in the Room object.
        assumptions possible:
            - Rntire rooms are configured atonce in the begining.
            - Rooms be Initialized as NULL be configed at runtime.

3. Booking a Room (Block room command)
    User issues a Block room command with time and duration.
    System validates 
    if available:
         → creates a booking entry
         → updates room status.
    If already booked:
        → error message shown.

4. Cancelling a Booking (Cancel Room command)
    User issues Cancel room command.
    System checks booking status 
    If booked:
        → releases booking 
        → updates room state.
    If not booked
        → error message shown.

5. Occupancy Detection (Add Occupant)
    User issues Add occupant command with number of people.
    If occupants ≥ 2
        → room marked occupied, notify observers (AC & Lights ON).
    If occupants = 0 
        → room unoccupied, notify observers (AC & Lights OFF).

        Patterns: Observer 
    If insufficient occupants (< 2) → room stays unoccupied.

6. Auto-Release Mechanism 
    If room booked but not occupied for > 5 minutes
        ->System automatically cancels booking and turns off AC & Lights.
    NOTE:
        ->Need to assign a seprate thread to a schudler to run the timer. 
            resource expensive if more number of rooms booked atonce.
        ->Have a Monitor Class and assign a single thread that checks the etire rooms 
        at certain interval of time.
            +ve good for sclable and to handle muitiple rooms.
            -ve rooms updated only after intervals.

7. Room Status Check
    User requests room status.
    System prints details:
         booking status,
         occupancy,
         AC & Lights state.




#Things that are not stated
    1. whether CONFIG be called only once at creation and throw an exception.
        or to initialize the object by creating a new instance , after confirmation from user.
    2. can occupant be Added even if the room is not booked at that time.
    3. cancel room clears the booking from the current state of the room or 
        entire future bookings of the room.
     
#Assumptions
    1. Initialize the object only once using Singleton pattern (only one office entity exists).
    2. occupants be added only if the room is booked at that time. 
        if not booked return can't occupancy a unbooked room.
    3. clear the current booking of the room once booking time ends.
            if already the room is occupied by >2:
                -notify all devices to turn off.
                -mark a not booked.

### Difficulty:
    -maintaining centralised time and syncronize it.
         