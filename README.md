Here is a **README.md written for the COM1003 Problem Sheet**, assuming the assignment has been fully completed and implemented according to the brief. 

You can paste this directly into your GitHub repository.

---

# COM1003 Problem Sheet – Theme Park Ticket System

## Overview

This project implements a **Theme Park Ticket Purchasing System** developed in Java as part of the **COM1003 Java Programming module** at the **University of Sheffield**.

The system models a theme park ticket management system that allows:

* Managing ticket categories and ticket types
* Creating and processing ticket purchases
* Detecting invalid purchases and preventing duplicates
* Handling ticket purchase limits
* Printing pending reservations
* Supporting concession tickets with discounts

The project was implemented using **object-oriented programming principles**, including inheritance, encapsulation, exception handling, and class relationships.

---

# System Description

The system simulates ticket management for a theme park called:

**Sheffield Adventure Land**

The application allows staff to:

* Define ticket categories
* Sell tickets to customers
* Validate purchases
* Manage ticket categories
* View pending reservations

The main execution class is:

```
App.java
```

---

# Ticket Categories

The system supports the following ticket categories:

### Day Pass

Valid for **one day**

| Ticket Type | Price |
| ----------- | ----- |
| Single      | £10   |
| Family      | £25   |

---

### Two-Day Pass

Valid for **two consecutive days**

| Ticket Type | Price |
| ----------- | ----- |
| Single      | £15   |
| Family      | £40   |

---

### Annual Pass

Valid for **one year**

| Ticket Type | Price |
| ----------- | ----- |
| Single      | £30   |
| Family      | £80   |

Each ticket category can contain **multiple ticket types**.

---

# Ticket Types

The base class for all ticket types is:

```
TicketType
```

Each ticket type includes:

* ticket name
* headcount (number of people allowed)
* base price

### Implemented Ticket Types

| Ticket Type | Description                            |
| ----------- | -------------------------------------- |
| Single      | One person ticket                      |
| Family      | Up to four people                      |
| Concession  | Discount ticket for eligible customers |

---

# Concession Tickets

A special ticket type called **Concession** was implemented.

Eligibility includes:

* Children under **18 years old**
* Seniors aged **65 or older**

Features:

* Default **20% discount**
* Stores the reason for concession
* Extends the `TicketType` class

Example:

```
Concession{discountRate=20%, reason=Senior Citizen}
```

---

# Purchases

The system records ticket purchases containing:

* customer name
* reservation date
* purchase date
* ticket category
* ticket type
* amount paid
* optional customer request

Example purchase output:

```
Purchase Made – John Smith
Category: Day Pass
Ticket Type: Single
Reservation Date: 2025-03-21
Amount Paid: £10.00
```

---

# Exception Handling

Several custom exceptions were implemented to ensure correct system behaviour.

### TicketLimitReachedException

Thrown when the park attempts to add **more than 10 ticket categories**.

---

### DuplicateReservationException

Thrown when:

* the **same customer**
* buys the **same ticket category and type**
* for the **same reservation date**

---

### PurchaseLimitReachedException

Thrown when the **maximum number of purchases allowed by the system is exceeded**.

---

### TicketNotFoundException

Thrown when:

* a purchase references a ticket category that **does not exist**, or
* a ticket category being removed **cannot be found**.

---

# Implemented Functionality

The following system features were implemented:

### Add Ticket Categories

Allows adding ticket categories to the theme park.

Example:

```
themePark.addTicketCategory(dayPass);
```

---

### Print Available Ticket Categories

Displays all ticket categories and their ticket types.

Example output:

```
Welcome to Sheffield Adventure Land

Available Ticket Categories:
Day Pass
  - Single (£10)
  - Family (£25)

Two-Day Pass
  - Single (£15)
  - Family (£40)

Annual Pass
  - Single (£30)
  - Family (£80)
```

---

### Make Purchases

Allows customers to buy tickets.

Example:

```
themePark.makePurchase(purchase);
```

The system validates:

* duplicate reservations
* ticket availability
* purchase limits

---

### Print Pending Tickets

Displays purchases where the reservation date is **in the future**.

Example output:

```
Pending Ticket Reservations:

Customer: Alice Brown
Category: Two-Day Pass
Reservation Date: 2025-04-02
```

---

### Compare Ticket Categories

Equality checks were implemented for:

```
TicketCategory.equals()
TicketType.equals()
```

Two ticket categories are considered equal if:

* their names match
* all ticket types have identical headcount and base prices

The comparison ignores ticket type names.

---

### Remove Ticket Category

Ticket categories can be removed by name.

Example:

```
themePark.removeTicketCategory("Annual Pass");
```

If the category does not exist, a `TicketNotFoundException` is thrown.

---

# Project Structure

```
src
 ├── main
 │   └── java
 │       └── uk.ac.sheffield.com1003.park
 │           ├── App.java
 │           ├── ThemePark.java
 │           ├── TicketCategory.java
 │           ├── TicketType.java
 │           ├── Purchase.java
 │           │
 │           ├── tickettypes
 │           │   ├── Single.java
 │           │   ├── Family.java
 │           │   └── Concession.java
 │           │
 │           └── exception
 │               ├── TicketLimitReachedException.java
 │               ├── DuplicateReservationException.java
 │               ├── PurchaseLimitReachedException.java
 │               └── TicketNotFoundException.java
 │
 └── test
     └── java
         └── uk.ac.sheffield.com1003.park
             └── TestPark.java
```

---

# Testing

JUnit tests were provided in:

```
src/test/java/uk.ac.sheffield.com1003.park.TestPark
```

These tests verify:

* ticket category printing
* purchase handling
* pending ticket detection
* correct system behaviour

All implemented functionality passes the provided tests.

Additional manual tests were also performed in `App.main()` to demonstrate:

* successful purchases
* triggered exceptions
* equality comparisons
* ticket removal

---

# Technologies Used

* Java
* Object-Oriented Programming
* Custom Exception Handling
* JUnit Testing
* Gradle Build System

---

# Key Programming Concepts Demonstrated

This project demonstrates:

* class design and encapsulation
* inheritance and subclassing
* exception handling
* equality comparison using `equals()`
* array manipulation
* object composition
* testing with JUnit

---

# Running the Program

Compile the project:

```
gradle build
```

Run the application:

```
gradle run
```

The program will execute the demonstration code in `App.main()` showing the system functionality.

---

# Author

COM1003 Java Programming
University of Sheffield

Theme Park Ticket System – Problem Sheet

---

If you want, I can also generate a **much shorter README (≈150–200 words)** which is often better for coursework submissions because markers usually prefer concise documentation.
