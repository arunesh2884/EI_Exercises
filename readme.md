**Exercise 1**
    -> Behaviour Pattern:
    
        1.Observer Pattern:
            useCase:
            Weather Monitoring System:
                The Observer pattern is applied to broadcast weather updates such as temperature, humidity, and rainfall to multiple observers. 
                In this system, displays like mobile apps, web dashboards, or LED boards act as observers, while the weather station acts as the subject.
                Whenever the weather data changes, all observers are instantly updated. This ensures accurate and consistent information delivery across various channels without manual intervention.
                
        2.StrategyPattern:
            UseCase:
            Payment Strategies in E-commerce:
                The Strategy pattern is implemented to allow an e-commerce system to support multiple payment methods like Credit Card, PayPal, and UPI.
                Instead of hardcoding logic for each payment type, the system defines a common PaymentStrategy interface, and each payment method provides its own implementation.
                At runtime, the customer can choose the preferred payment option, and the context dynamically applies the corresponding strategy. This design improves flexibility, reduces code duplication, and makes it easy to add or modify payment methods in the future.
                
    -> Creational Pattern:
        1.Builder Pattern:
            Usecase:
            Pizza Creation in Food Ordering System:
                The Builder pattern is used to construct complex pizza objects step by step without requiring a large telescoping constructor.
                By separating the construction process from the representation, the system allows customers to create pizzas of varying sizes, toppings, and customizations dynamically.
                Each builder method sets a specific attribute, and the final build() method produces the complete pizza object. This approach improves code readability, supports flexibility in creating multiple variations, and makes it easy to extend the system with new ingredients or customization options.

        2.Singleton Pattern:
            Logger System:
            The Singleton pattern is used to implement a global logger accessible across all components of the system. This logger instance handles all application logs including errors, warnings, and info messages. Having a single instance avoids inconsistencies and reduces memory overhead. It ensures that all logs are written in a uniform manner, supporting better debugging and monitoring.

    -> Structural Pattern:
        1.Bridge Pattern:
            The Bridge pattern is a structural design pattern that separates an abstraction from its implementation, allowing them to vary independently.
            It decouples an object's abstraction from its implementation, making it possible to change the implementation without affecting the abstraction.
        Use Cases:
            Fuel Station:
                The Bridge pattern is used to separate the fueling process abstraction from its underlying brand implementations.
                With this design, a fueling station can provide services from brands like HP and Shell using the same abstraction. 
                This reduces code duplication and promotes flexibility when extending the system to include more fuel providers. 
                It ensures a clean separation of concerns while allowing smooth integration of new vendors.

        2.Adapter Pattern:
            UseCase:
            Media Player:
                    The Adapter pattern is used to enable a single media player to support multiple file formats such as MP3, MP4, and VLC.
                    Each specific format player (like MP3Player or VLCPlayer) has its own unique API, but through adapters they are made compatible with a common MediaPlayer interface.
                    This allows the client to play different media types without worrying about format-specific implementations. The approach promotes code reuse and improves extensibility.

**Exercise 2:**
    Smart_Office_Facility:
        A console-based Java application that manages a smart office environment with features such as conference room booking, occupancy detection, and automated control of air conditioning and lighting. The project demonstrates OOP principles, design patterns, and clean coding practices for building scalable, maintainable systems.

