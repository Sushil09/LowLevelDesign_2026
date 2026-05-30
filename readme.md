# Low-Level Design (LLD) 2026

A comprehensive Java implementation of common **Low-Level Design (LLD)** problems and design patterns. This repository contains solutions to frequently asked interview questions that help you understand how to design and implement scalable, maintainable systems.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Key Design Patterns](#key-design-patterns)
- [LLD Questions Covered](#lld-questions-covered)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Building & Running](#building--running)
- [Key Concepts](#key-concepts)

---

## Overview

This project demonstrates best practices for **Low-Level Design**, focusing on:

✅ **Object-Oriented Principles** - Inheritance, Polymorphism, Encapsulation, Abstraction  
✅ **Design Patterns** - Command Pattern, Factory Pattern, Observer Pattern, Singleton, Strategy, etc.  
✅ **System Design** - Scalable architectures for real-world problems  
✅ **Clean Code** - SOLID principles, readable, maintainable code  

---

## Key Design Patterns

### 1. **Command Pattern** (FileSystems_CommandPattern.java)
**Purpose:** Encapsulate requests as objects to parameterize clients with different requests, queue requests, and log requests.

**Real-world Application:** File System Operations
- Represents file and directory operations as commands
- Supports hierarchical file system structures
- Enables operations like `ls()` on both files and directories

**Key Classes:**
- `FileSystem` - Interface defining the contract
- `File` - Represents a file entity
- `Directory` - Represents a directory with nested files and directories

**When to Use:**
- Undo/redo functionality
- Macro recording
- Task scheduling
- Transaction management

---

### 2. **Tic Tac Toe Game** (TicTacToe.java)
**Purpose:** Implement a fully functional Tic Tac Toe game demonstrating object-oriented design.

**Key Classes:**
- `Game` - Main game orchestrator
- `Board` - Game board state management
- `Player` - Player information and moves

**Design Considerations:**
- Game state management
- Win/Draw condition checking
- Turn management between players
- Input validation

**Concepts Covered:**
- State management
- Game logic design
- Player management
- Board representation

---

## LLD Questions Covered

### System Design Problems

#### 1. **File System Design** ⭐⭐⭐
- **Problem:** Design a hierarchical file system that supports files and directories
- **Key Features:**
  - Create files and directories
  - List contents of directories
  - Support nested directory structures
  - Track file metadata (name, size, etc.)
- **Patterns Used:** Composite Pattern, Command Pattern
- **Implementation:** `FileSystems_CommandPattern.java`

#### 2. **Tic Tac Toe Game** ⭐⭐⭐
- **Problem:** Design a Tic Tac Toe game with proper game logic
- **Key Features:**
  - 3x3 game board
  - Two-player game mechanics
  - Win condition validation
  - Draw/tie detection
  - Move validation
- **Patterns Used:** State Pattern, Strategy Pattern
- **Implementation:** `TicTacToe.java`

---

## Problem-Solving Checklist for LLD

When approaching an LLD problem, follow this checklist:

### 1. **Requirements Gathering**
- [ ] Clarify functional requirements
- [ ] Understand constraints and scale
- [ ] Identify key entities
- [ ] List out all operations needed

### 2. **Core Entities Design**
- [ ] Identify main classes/entities
- [ ] Define relationships between entities
- [ ] Determine data structures needed
- [ ] Plan inheritance hierarchies

### 3. **Design Patterns**
- [ ] Identify applicable design patterns
- [ ] Plan interface/abstract class structures
- [ ] Consider extensibility for future changes

### 4. **Algorithm & Logic**
- [ ] Design core algorithms
- [ ] Handle edge cases
- [ ] Plan validation logic
- [ ] Consider error handling

### 5. **Implementation**
- [ ] Follow SOLID principles
- [ ] Write clean, readable code
- [ ] Use proper naming conventions
- [ ] Add documentation

### 6. **Testing**
- [ ] Test happy paths
- [ ] Test edge cases
- [ ] Test error scenarios
- [ ] Validate constraints

---

## Project Structure

```
LowLevelDesign_2026/
├── src/
│   ├── main/java/
│   │   ├── org/example/
│   │   │   └── App.java                    # Entry point
│   │   └── com/lld/systems/
│   │       ├── fileSystems/
│   │       │   └── FileSystems_CommandPattern.java
│   │       └── tictactoe/
│   │           └── TicTacToe.java
│   └── test/                               # Unit tests
├── pom.xml                                 # Maven configuration
└── README.md                               # This file
```

---

## Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 11+ | Language |
| **Maven** | 3.8+ | Build tool |
| **Lombok** | 1.18.36+ | Boilerplate reduction |
| **JUnit** | 3.8.1+ | Unit testing |

### Prerequisites
- Java 11 or higher
- Maven 3.8 or higher
- Git (optional, for version control)

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/LowLevelDesign_2026.git
cd LowLevelDesign_2026
```

### 2. Verify Prerequisites
```bash
java -version
mvn -version
```

---

## Building & Running

### Build the Project
```bash
mvn clean compile
```

### Run a Specific Class
```bash
# Run App class
mvn exec:java -Dexec.mainClass="org.example.App"

# Run File System example
mvn exec:java -Dexec.mainClass="com.lld.systems.fileSystems.FileSystems_CommandPattern"

# Run Tic Tac Toe example
mvn exec:java -Dexec.mainClass="com.lld.systems.tictactoe.TicTacToe"
```

### Run Tests
```bash
mvn test
```

---

## Key Concepts

### SOLID Principles

| Principle | Description | Example |
|-----------|-------------|---------|
| **S**ingle Responsibility | Each class should have one reason to change | `File` class only handles file operations |
| **O**pen/Closed | Open for extension, closed for modification | Interface `FileSystem` allows new implementations |
| **L**iskov Substitution | Subtypes should be substitutable for base types | `File` and `Directory` can replace `FileSystem` |
| **I**nterface Segregation | Many specific interfaces > one general interface | Separate concerns into focused interfaces |
| **D**ependency Inversion | Depend on abstractions, not concrete classes | Depend on `FileSystem` interface, not implementations |

### Design Patterns Explained

#### **Command Pattern**
```
Problem: How to encapsulate requests as objects?
Solution: Create command objects that encapsulate the request
Benefits: Decouple object that invokes from object that performs
```

#### **Composite Pattern**
```
Problem: How to compose objects into tree structures?
Solution: Treat individual objects and compositions uniformly
Benefits: Simplify client code, build complex hierarchies easily
```

#### **Strategy Pattern**
```
Problem: How to define algorithms and make them interchangeable?
Solution: Create family of algorithms in separate classes
Benefits: Encapsulate varying behavior, select at runtime
```

---

## Interview Tips

### For LLD Problems:

1. **Start with Clarifying Questions**
   - Ask about scale/requirements
   - Understand edge cases
   - Clarify assumptions

2. **Design Top-Down**
   - Start with high-level entities
   - Define relationships
   - Refine as you go

3. **Consider Extensibility**
   - Use interfaces/abstract classes
   - Apply design patterns appropriately
   - Plan for future features

4. **Code Quality Matters**
   - Use meaningful names
   - Follow SOLID principles
   - Handle errors gracefully

5. **Discuss Trade-offs**
   - Explain design decisions
   - Discuss time/space complexity
   - Consider alternatives

---

## Common LLD Interview Questions

### Frequently Asked Questions

1. **File System Design** - Design a file system with files and directories ⭐⭐⭐
2. **Tic Tac Toe** - Implement a Tic Tac Toe game ⭐⭐⭐
3. **Parking Lot** - Design a multi-level parking system ⭐⭐⭐⭐
4. **Library Management** - Design a library system ⭐⭐⭐
5. **Hotel Management** - Design a hotel booking system ⭐⭐⭐⭐
6. **Elevator System** - Design an elevator system ⭐⭐⭐⭐
7. **Chess Game** - Implement a chess game ⭐⭐⭐⭐⭐
8. **Snake & Ladder** - Implement the game ⭐⭐⭐
9. **ATM Machine** - Design an ATM system ⭐⭐⭐
10. **Ride Sharing (Uber)** - Design a ride-sharing system ⭐⭐⭐⭐⭐

*⭐ = Difficulty level (1=Easy, 5=Hard)*

---

## Learning Resources

### Recommended Topics to Study
- Object-Oriented Programming (OOP) fundamentals
- Design Patterns (GoF patterns)
- SOLID Principles
- Data Structures & Algorithms
- System Design basics

### External References
- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)
- Head First Design Patterns
- Clean Code by Robert C. Martin
- Refactoring: Improving the Design of Existing Code

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-lld-question`)
3. Commit your changes (`git commit -m 'Add new LLD implementation'`)
4. Push to the branch (`git push origin feature/new-lld-question`)
5. Open a Pull Request

---

## Code Quality Standards

When adding new implementations:

✅ Follow Java naming conventions  
✅ Add appropriate Javadoc comments  
✅ Use design patterns appropriately  
✅ Apply SOLID principles  
✅ Write unit tests  
✅ Ensure code is readable and maintainable  

---

## Troubleshooting

### Common Issues

**Issue:** `ExceptionInInitializerError: TypeTag :: UNKNOWN`
```
Solution:
- Update Lombok to latest version (1.18.38+)
- Add Maven compiler configuration with Java 11+
- Run: mvn clean compile
```

**Issue:** Maven build fails
```
Solution:
- Ensure Java 11+ is installed
- Run: mvn clean install -DskipTests
- Check Maven settings in ~/.m2/settings.xml
```

---

## Future Roadmap

- [ ] Add Parking Lot System Design
- [ ] Add Library Management System
- [ ] Add Hotel Booking System
- [ ] Add Elevator System Design
- [ ] Add Chess Game Implementation
- [ ] Add comprehensive unit tests
- [ ] Add design pattern examples
- [ ] Add complexity analysis for each solution

---

## License

This project is licensed under the MIT License - see LICENSE file for details.

---

## Contact & Support

For questions or suggestions about this project, feel free to:
- Open an Issue on GitHub
- Create a Discussion
- Submit a Pull Request with improvements

---

## Acknowledgments

Built as a comprehensive learning resource for Low-Level Design interview preparation. Inspired by real-world system design challenges and common interview questions.

---

**Happy Learning! 🚀**

For more details on each implementation, check the source code in `src/main/java/` directory.
