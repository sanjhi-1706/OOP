#include <iostream>
#include <iomanip>
#include <cstring>

using namespace std;

class Student {
private:
    int admNo;
    char name[21];
    float marksEng;
    float marksMaths;
    float marksSci;
    float total;

    inline void compute() {
        total = marksEng + marksMaths + marksSci;
    }

public:
    void readData() {
        cout << "Enter admission number: ";
        cin >> admNo;

        cout << "Enter name (max 20 characters): ";
        cin>>name;

        cout << "Enter marks in English: ";
        cin >> marksEng;

        cout << "Enter marks in Mathematics: ";
        cin >> marksMaths;

        cout << "Enter marks in Science: ";
        cin >> marksSci;

        compute();
    }

    void showData() {
        cout << "Admission Number: " << admNo << endl;
        cout << "Name: " << name << endl;
        cout << "Marks in English: " << marksEng << endl;
        cout << "Marks in Mathematics: " << marksMaths << endl;
        cout << "Marks in Science: " << marksSci << endl;
        cout << "Total Marks: " << total << endl;
    }

    static void displayWelcomeMessage() {
        cout << "Welcome to the Student Data Management System!" << endl;
    }
};



int main() {
    Student::displayWelcomeMessage();

    Student student;

    student.readData();
    cout << "\nStudent Data:\n";
    student.showData();

    return 0;
}
