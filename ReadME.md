# About this Project

- This project focuses on building an INOX Movie Booking Console Application using Java. 
- The application is developed as a Gradle project with a proper package structure.
- JSON files are used to store and retrieve data instead of a database.
- We are using UUID to generate unique id.

### File Structure of the Project

```
Inox/app/src/main
|-java
|   |
|   |- org
|   |   |
|   |   |- controller
|   |   |   |- app
|   |   |
|   |   |- entity
|   |   |   |- Booking
|   |   |   |- Hall
|   |   |   |- Seat
|   |   |   |- User
|   |   |
|   |   |- repository
|   |   |   |- ManageRepository
|   |   |
|   |   |- Service
|   |   |   |- BookingService
|   |   |   |- UserService
|   |   |
|   |   |- Utility
|   |   |   |- Utility
Inox/Data
|   |- Booking.json
|   |- Hall.json
|   |- Seat.json
|   |- User.json
```


## Controller package / app file

- It is the entry point of the application which contains the `main(String [] args)` method.

## entity package
- It contains the entity class which we are using to store on json file.

## repository package
- It contains the `ManageRepository` class which contains method to read and write data on json file.

## service package
- It contains UserService and BookingService which contains the logics to create New User account, login User, Book Movie Ticket, etc.

## Utility
- It contains the utility methods like generate UUID which will be used as ID on the entity.