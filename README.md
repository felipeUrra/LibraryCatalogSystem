# 📚 Library Catalog System
A Java-based Command Line Interface (CLI) application designed to manage a digital library of books and research papers. This project demonstrates advanced Object-Oriented Programming (OOP) principles, polymorphic data handling, and automated file persistence.

## 🚀 Key Features
- Polymorphic Inventory: Seamlessly handle different item types (Book, Paper) within a single unified system.
- Automated Persistence: Data is automatically saved to and loaded from a local library.json file using the Jackson library.
- Smart PDF Integration: Built-in functionality to open PDF files directly from the CLI using the system's default viewer.
- Robust Input Handling: Protected against common CLI input errors and "Scanner buffer" issues.
- Search & Remove: Find specific items by name and manage inventory with ease.

## 🛠️ CommandsOnce the program is running, you can use the following commands:
- add book, Prompt for details to add a new Book to the library.
- add paper, Prompt for details to add a new Research Paper.
- remove, Search for an item by name and remove it from the system.
- print all, Display the details of every item in the inventory.
- print all name, Search and display all items matching a specific title.
- open, Search for a PDF item and open it in the system's default viewer.
- exit, Save all changes to the database and close the program.

## 📦 Libraries Used
This project utilizes Maven for dependency management and the following libraries:

- Jackson Databind (2.17.2): Used for high-performance JSON serialization and deserialization, specifically handling abstract class polymorphism through type annotations.
- Java Desktop API: Utilized for native OS file integration to launch external PDF readers.
