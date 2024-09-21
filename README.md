

# Tierheimverwaltungssystem (Animal Shelter Management System)

This project is a Java-based application designed to manage an animal shelter efficiently. It provides functionality to register new animals, update their status, manage adoptions, and handle various operations essential for running a shelter.

## Features

1. **Animal Class**: 
   - An abstract class representing an animal with attributes such as name, date of birth, status, and hunger level. 
   - This class ensures encapsulation by keeping some fields private and immutable, such as `name` and `dateOfBirth`, which cannot be changed once set.
   
2. **AdoptingManagement Class**:
   - A class that handles the storage and management of animals in the shelter.
   - It maintains an array of `Animal` objects and defines methods for adding new arrivals, adopting animals, and updating their status.
   - Manages different animal statuses such as "New Arrival", "Quarantine", "Reserved", and "Adopted".

3. **Animal-Specific Classes**:
   - `Cat` and `Fox` classes inherit from the `Animal` class and implement the `Carnivore` interface. 
   - These classes define their own behavior, such as how they make sounds and how they are fed.

4. **Adoption Process**:
   - The `AdoptingManagement` class provides functionalities to adopt animals based on their ID. It checks if the animal is available for adoption and updates its status accordingly.
   
5. **Helper Methods**:
   - Various helper methods to get an animal's age, find empty spots for new arrivals, retrieve the names of all animals, and more.

## How to Use

1. **Initialization**:
   - The system initializes with a set of animals using the `AdoptingManagement` class. New animals can be added using the `newArrival()` method, and their information is stored in an internal array.

2. **Status Updates**:
   - Each animal has a status that can be updated through the `updateStatus()` method. The system checks for valid status transitions before allowing updates.

3. **Adopting Animals**:
   - The `adoptAnimal()` method allows the adoption of animals, provided the animal is not in quarantine. The status is updated to "Adopted" after a successful adoption.

4. **Feeding Carnivores**:
   - Carnivorous animals such as cats and foxes are fed using the `feed(Meat meat)` method defined in the `Carnivore` interface.

5. **JUnit Testing**:
   - All public methods are tested using JUnit to ensure functionality and stability.

## Running the Project

- Ensure you have JDK installed (Java SE 8 or higher).
- Compile and run the code using your preferred IDE or the command line.
- The system can be extended by adding more animals or new features as needed.

## Future Improvements

- Implementing a more robust status management system using enumerations instead of strings.
- Extending the system to handle more animal types and more complex shelter management operations.
- Adding a user-friendly interface for better interaction with the shelter system.

---
