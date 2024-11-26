#include <iostream>
#include <ctime>
#include <cstdlib>
#include <string>

using namespace std;

int main() {
    srand(time(0)); // seed the random number generator

    string subjects[] = {"Math", "DBMS", "English", "OOP", "CO"};
    string teachers[] = {"Johnson", "Ms. Smith", "Mr. Davis", "Ms. Thompson", "Mr. Brown"};

    int subjectIndex = rand() % 5; // generate a random index for subjects
    int teacherIndex = rand() % 5; // generate a random index for teachers

    cout << "Class Period Details:" << endl;
    cout << "Subject: " << subjects[subjectIndex] << endl;
    cout << "Teacher: " << teachers[teacherIndex] << endl;

    return 0;
}