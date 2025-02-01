# Shopping-Website-DB-

# Online Shopping Management System

This Java-based **Online Shopping Management System** is designed to help administrators manage products, users, and shopping websites efficiently. It provides a **Graphical User Interface (GUI)** using **Swing**, and it connects to a **MySQL database** for data storage.

## Features:
- **User Management:** Add, update, and delete users with details such as name, phone number, and email.
- **Product Management:** Manage product inventory, including adding, updating, and deleting products.
- **Shopping Website Management:** Maintain records of shopping websites, including names, URLs, and types.
- **Database Integration:** Uses **MySQL** for storing and retrieving data.
- **GUI Interface:** Built with Java **Swing** for an interactive user experience.

## Components:
- **GUI380CSC.java:** The graphical interface for managing products.
- **shopping_website.java:** Manages shopping website records.
- **User.java:** Handles user data management.
- **MySQL Database:** Stores products, users, and website data.

## How to Run:
1. Ensure **MySQL** is installed and set up with a database named **"online shopping website"**.
2. Update the database credentials in the Java files if needed.
3. Compile and run:
   ```bash
   javac GUI380CSC.java shopping_website.java User.java
   java GUI380CSC
