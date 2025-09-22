// Harsh panchal , roll - 2401350007

#include <iostream>
#include <string>
using namespace std;

// ================== Weather Record ADT ==================
class WeatherRecord {
public:
    string date;     // format: DD/MM/YYYY
    string city;     
    double temperature;

    WeatherRecord() {
        date = "";
        city = "";
        temperature = -9999; // sentinel for missing data
    }

    WeatherRecord(string d, string c, double t) {
        date = d;
        city = c;
        temperature = t;
    }
};

// ================== Weather Data Storage ==================
class WeatherDataStorage {
private:
    static const int MAX_YEARS = 5;   // for simplicity
    static const int MAX_CITIES = 5;  
    double data[MAX_YEARS][MAX_CITIES]; // 2D array: rows=years, cols=cities
    string cities[MAX_CITIES] = {"Delhi", "Mumbai", "Chennai", "Kolkata", "Bengaluru"};
    int years[MAX_YEARS] = {2020, 2021, 2022, 2023, 2024};

public:
    // Constructor initializes all to sentinel
    WeatherDataStorage() {
        for (int i = 0; i < MAX_YEARS; i++) {
            for (int j = 0; j < MAX_CITIES; j++) {
                data[i][j] = -9999; // sentinel for missing data
            }
        }
    }

    // Insert temperature
    void insert(int year, string city, double temp) {
        int row = getYearIndex(year);
        int col = getCityIndex(city);
        if (row != -1 && col != -1) {
            data[row][col] = temp;
            cout << "Inserted: " << city << " (" << year << ") -> " << temp << "°C\n";
        } else {
            cout << "Invalid city/year.\n";
        }
    }

    // Delete record
    void deleteRecord(int year, string city) {
        int row = getYearIndex(year);
        int col = getCityIndex(city);
        if (row != -1 && col != -1) {
            data[row][col] = -9999;
            cout << "Record deleted for " << city << " (" << year << ")\n";
        } else {
            cout << "Invalid city/year.\n";
        }
    }

    // Retrieve data for city across years
    void retrieve(string city) {
        int col = getCityIndex(city);
        if (col == -1) {
            cout << "City not found.\n";
            return;
        }
        cout << "Temperatures for " << city << ":\n";
        for (int i = 0; i < MAX_YEARS; i++) {
            if (data[i][col] != -9999)
                cout << years[i] << ": " << data[i][col] << "°C\n";
            else
                cout << years[i] << ": No Data\n";
        }
    }

    // Row-major access
    void rowMajorAccess() {
        cout << "\nRow-major access (Year-wise):\n";
        for (int i = 0; i < MAX_YEARS; i++) {
            for (int j = 0; j < MAX_CITIES; j++) {
                cout << data[i][j] << " ";
            }
            cout << endl;
        }
    }

    // Column-major access
    void columnMajorAccess() {
        cout << "\nColumn-major access (City-wise):\n";
        for (int j = 0; j < MAX_CITIES; j++) {
            for (int i = 0; i < MAX_YEARS; i++) {
                cout << data[i][j] << " ";
            }
            cout << endl;
        }
    }

    // Sparse data check
    void handleSparseData() {
        int missing = 0, total = MAX_YEARS * MAX_CITIES;
        for (int i = 0; i < MAX_YEARS; i++) {
            for (int j = 0; j < MAX_CITIES; j++) {
                if (data[i][j] == -9999)
                    missing++;
            }
        }
        cout << "Sparse Data Handling:\n";
        cout << "Total entries: " << total << ", Missing: " << missing << "\n";
    }

private:
    int getCityIndex(string city) {
        for (int i = 0; i < MAX_CITIES; i++) {
            if (cities[i] == city) return i;
        }
        return -1;
    }

    int getYearIndex(int year) {
        for (int i = 0; i < MAX_YEARS; i++) {
            if (years[i] == year) return i;
        }
        return -1;
    }
};

// ================== Main with Switch Menu ==================
int main() {
    WeatherDataStorage storage;
    int choice;
    do {
        cout << "\n=== Weather Data Storage Menu ===\n";
        cout << "1. Insert Record\n";
        cout << "2. Delete Record\n";
        cout << "3. Retrieve City Data\n";
        cout << "4. Row-Major Access\n";
        cout << "5. Column-Major Access\n";
        cout << "6. Handle Sparse Data\n";
        cout << "0. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            int year;
            string city;
            double temp;
            cout << "Enter Year (2020-2024): ";
            cin >> year;
            cout << "Enter City (Delhi/Mumbai/Chennai/Kolkata/Bengaluru): ";
            cin >> city;
            cout << "Enter Temperature: ";
            cin >> temp;
            storage.insert(year, city, temp);
            break;
        }
        case 2: {
            int year;
            string city;
            cout << "Enter Year (2020-2024): ";
            cin >> year;
            cout << "Enter City: ";
            cin >> city;
            storage.deleteRecord(year, city);
            break;
        }
        case 3: {
            string city;
            cout << "Enter City: ";
            cin >> city;
            storage.retrieve(city);
            break;
        }
        case 4:
            storage.rowMajorAccess();
            break;
        case 5:
            storage.columnMajorAccess();
            break;
        case 6:
            storage.handleSparseData();
            break;
        case 0:
            cout << "Exiting...\n";
            break;
        default:
            cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 0);

    return 0;
}
