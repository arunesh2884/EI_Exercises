
---

###  Folder Details

- **`Cli/`**  
  Implements the command-line interface for the project.  
  -Contains the implementation of Command Pattern (eg. ConfigCommand.java , BlockCommand.java,..)
  -Decorator class
  -Menu class where the menu.show() is call recursivly to keep the system live.

- **`Exceptions/`**  
  Contains all custom exceptions (e.g., `BookingException`, `ConfigException`,`occupyingException`) to manage errors cleanly.

- **`Models/`**  
  Defines the core entities of the system:
  - `Office`
  - `Room`
  - `Booking`
  - `Device`
  - `RoomState` (enum)

- **`Services/`**  
  Contains the business logic for the system:
  - RoomManager
      - Contains the rooms.
      - Maintains the bookings and room state and sync to the system.
  - DeviceManager
      - Notify the IOT devices to update their state based on the no_of_occupancy

- **`Utils/`**  
  Helper functions and reusable utilities:
  - TimeUtils
      -> Maintains the format HH:MM
      -> Compare two times
      -> Return current time

- **`Main.java`**  
  The entry point of the application.  
  Initializes the system and starts the command-line interface calls the Menu.show().
