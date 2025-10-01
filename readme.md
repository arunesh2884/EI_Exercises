# EI_Exercises

This repository contains Java-based programming exercises focusing on **Object-Oriented Programming (OOP) principles** and **Design Patterns**.  
The exercises demonstrate practical implementations of **behavioral, creational, and structural patterns**, along with a complete console-based application simulating a smart office environment.

---

## 📘 Exercise 1: Design Pattern Implementations

### 🔹 Behavioral Patterns

#### 1. Observer Pattern
**Use Case: Weather Monitoring System**  
- The `Observer` pattern is applied to broadcast weather updates (temperature, humidity, rainfall) to multiple observers.  
- Observers: Mobile apps, web dashboards, LED boards.  
- Subject: Weather station.  
- Whenever the weather data changes, all observers are instantly updated.  
✅ Ensures accurate and consistent information delivery across multiple channels without manual intervention.

#### 2. Strategy Pattern
**Use Case: Payment Strategies in E-commerce**  
- The `Strategy` pattern allows an e-commerce system to support multiple payment methods such as Credit Card, PayPal, and UPI.  
- A `PaymentStrategy` interface defines common behavior, and each payment method implements its own strategy.  
- At runtime, the customer selects the desired payment method.  
✅ Improves flexibility, reduces code duplication, and makes it easy to add/modify payment options.

---

### 🔹 Creational Patterns

#### 1. Builder Pattern
**Use Case: Pizza Creation in Food Ordering System**  
- The `Builder` pattern constructs complex pizza objects step by step.  
- Customers can create pizzas with varying sizes, toppings, and customizations.  
- Each builder method sets a specific attribute, and `build()` produces the final pizza object.  
✅ Improves code readability, flexibility, and makes the system easy to extend with new ingredients.

#### 2. Singleton Pattern
**Use Case: Logger System**  
- The `Singleton` pattern ensures only one instance of a global logger exists.  
- This logger handles all application logs (errors, warnings, info).  
✅ Guarantees consistency, reduces memory overhead, and centralizes logging for better debugging.

---

### 🔹 Structural Patterns

#### 1. Bridge Pattern
**Use Case: Fuel Station**  
- The `Bridge` pattern decouples abstraction from implementation, allowing independent variations.  
- Example: A fueling station provides services from different brands (HP, Shell) using the same abstraction.  
✅ Reduces code duplication, promotes flexibility, and enables clean integration of new fuel providers.

#### 2. Adapter Pattern
**Use Case: Media Player**  
- The `Adapter` pattern enables a media player to support multiple file formats (MP3, MP4, VLC).  
- Each specific player (e.g., `MP3Player`, `VLCPlayer`) has its own API, but adapters unify them under a common `MediaPlayer` interface.  
✅ Promotes code reuse and extensibility while hiding format-specific details from the client.

---

## 📘 Exercise 2: Smart Office Facility

### 🏢 Project Overview
A **console-based Java application** that manages a smart office environment with features such as:
- Conference room booking
- Occupancy detection
- Automated control of air conditioning and lighting

The project demonstrates:
- **Object-Oriented Programming (OOP) principles**
- **Design Patterns (Singleton, Observer)**
- **Clean coding practices**
- **Scalable and maintainable system design**

---

### ⚙️ Functional Requirements
1. Configure the office facility by specifying the number of meeting rooms.
2. Book and cancel bookings for conference rooms.
3. Detect occupancy using sensors (≥2 people required to mark occupied).
4. Auto-release unoccupied bookings if not used within 5 minutes.
5. Automatically turn AC and lights **OFF** when rooms are unoccupied.

---

### 🔄 User Flow
1. **System Initialization (`Config` command)**  
   - Creates rooms with default states (unoccupied, no booking, AC/Lights OFF).  
   - Pattern: `Singleton`.  

2. **Room Configuration (`Config room` command)**  
   - Sets maximum capacity of rooms.  

3. **Booking (`Block room` command)**  
   - Books a room if available, else returns an error.  

4. **Cancelling Booking (`Cancel room` command)**  
   - Cancels a booking if active.  

5. **Occupancy Detection (`Add occupant` command)**  
   - If occupants ≥2 → Room marked occupied (AC/Lights ON).  
   - If occupants =0 → Room unoccupied (AC/Lights OFF).  
   - Pattern: `Observer`.  

6. **Auto-Release Mechanism**  
   - If booked but unused for >5 minutes → Booking cancelled, AC/Lights OFF.  
   - Implemented using a monitoring service with a scheduler.  

7. **Room Status Check**  
   - Prints booking status, occupancy, AC, and lighting state.  



