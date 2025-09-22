# Weather Data Storage System

Name: Harsh Panchal
Roll No: 2401350007

#  Project Overview

This project is a simple C++ program to store and manage weather data like temperature for different cities and years.

It uses:

2D Array → to store data (Years × Cities)

Switch-case Menu → to make the program interactive

# Features

Insert a temperature record

Delete a record

Retrieve temperature of a city for all years

Display data in row-major (year-wise) order

Display data in column-major (city-wise) order

Handle missing data (uses -9999 for no data)

# How It Works

When you run the program, you will see a menu:

=== Weather Data Storage Menu ===
1. Insert Record
2. Delete Record
3. Retrieve City Data
4. Row-Major Access
5. Column-Major Access
6. Handle Sparse Data
0. Exit


# You just need to enter a number (like 1 to insert data).

# Example Run
Enter your choice: 1
Enter Year (2020-2024): 2021
Enter City (Delhi/Mumbai/Chennai/Kolkata/Bengaluru): Delhi
Enter Temperature: 27.5
Inserted: Delhi (2021) -> 27.5°C

Enter your choice: 3
Enter City: Delhi
Temperatures for Delhi:
2020: No Data
2021: 27.5°C
2022: No Data
2023: No Data
2024: No Data

# Time Complexity (Simple Explanation)

Insert/Delete → O(1) (very fast)

Retrieve → O(years)

Display (row/column) → O(years × cities)

# What I Learned

How to use classes in C++

How to work with 2D arrays

How to make a program menu-driven using switch-case

How to manage missing data

# Conclusion

This is a simple beginner project that shows how to use arrays, classes, and menus in C++.
