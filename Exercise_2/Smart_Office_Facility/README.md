# Smart_Office_Facility
A console-based Java application that manages a smart office environment with features such as conference room booking, occupancy detection, and automated control of air conditioning and lighting. The project demonstrates OOP principles, design patterns, and clean coding practices for building scalable and maintainable systems.

---

## Functional Requirements

### Mandatory Requirements
1. The system should allow users to configure the office facility by specifying the number of meeting rooms.
2. Users should be able to book and cancel bookings for conference rooms.
3. Occupancy should be detected using sensors that register when at least two people enter a room.
4. Unoccupied rooms should automatically release bookings if not occupied within 5 minutes.
5. The air conditioning and lights should turn off if the room is not occupied.

---

## User Flow of the Project

### 1. System Initialization (`Config` command)
- User configures the office by specifying the number of meeting rooms.
- System creates `Room` objects with default states:
    - Unoccupied
    - No booking
    - AC and Lights OFF
- **Pattern:** `Singleton` — ensures only one System object is created.

### 2. Room Configuration (`Config room` command)
- User sets maximum capacity of rooms.
- Updates attributes in the `Room` object.
- **Assumptions:**
    - Entire rooms are configured at once at the beginning.
    - Rooms may be initialized as `NULL` and configured at runtime.

### 3. Booking a Room (`Block room` command)
- User issues a `Block room` command with time and duration.
- System validates availability:
    - If available:
        - Creates a booking entry
        - Updates room status
    - If already booked:
        - Shows an error message

### 4. Cancelling a Booking (`Cancel room` command)
- User issues `Cancel room` command.
- System checks booking status:
    - If booked:
        - Releases booking
        - Updates room state
    - If not booked:
        - Shows an error message

### 5. Occupancy Detection (`Add Occupant` command)
- User issues `Add occupant` command with the number of people.
- Logic:
    - If occupants ≥ 2:
        - Room marked **occupied**
        - Notify observers (AC & Lights ON)
    - If occupants = 0:
        - Room marked **unoccupied**
        - Notify observers (AC & Lights OFF)
    - If occupants < 2:
        - Room stays unoccupied
- **Pattern:** `Observer` — devices react to occupancy changes.

### 6. Auto-Release Mechanism
- If a room is booked but not occupied for > 5 minutes:
    - System automatically cancels booking
    - Turns off AC & Lights
- **Implementation Notes:**
    - A separate thread can run a scheduler to check room occupancy.
    - Use a `Monitor` class to handle multiple rooms efficiently.
    - **Pros:** Scalable and handles multiple rooms.
    - **Cons:** Rooms are updated only at scheduled intervals.

### 7. Room Status Check
- User requests room status.
- System prints details:
    - Booking status
    - Occupancy
    - AC & Lights state

---

## Notes and Unclear Requirements
1. Should `CONFIG` be called only once at creation and throw an exception on further calls, or allow re-initialization after user confirmation?  
2. Can occupants be added even if the room is not booked?  
3. Does `Cancel room` clear only the current booking or all future bookings of the room?  

---

## Assumptions
1. Initialize the office object only once using the `Singleton` pattern.  
2. Occupants can be added **only if the room is booked** at that time.  
3. Clear only the current booking once the booking time ends.  
    - If the room is already occupied by ≥2 people:
        - Notify devices to turn off
        - Mark the room as not booked

---

## Difficulty
- Maintaining a centralized time system and synchronizing room states.
