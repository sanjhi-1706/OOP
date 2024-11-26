#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Student {
private:
    string name;
    int score;

public:
    Student(string studentName, int studentScore)
        : name(studentName), score(studentScore) {}

    string getName() const {
        return name;
    }

    int getScore() const {
        return score;
    }
};

class ClassRoom {
private:
    vector<Student> students;

public:
    // Method to add a student
    void addStudent(const Student& student) {
        students.push_back(student);
    }

    // Method to find and return the name of the topper
    string findTopper() const {
        if (students.empty()) {
            return "No students in the list";
        }

        string topperName = students[0].getName();
        int highestScore = students[0].getScore();

        for (const auto& student : students) {
            if (student.getScore() > highestScore) {
                highestScore = student.getScore();
                topperName = student.getName();
            }
        }

        return topperName;
    }
};

int main() {
    
    ClassRoom classRoom;

    classRoom.addStudent(Student("Alice", 85));
    classRoom.addStudent(Student("Bob", 92));
    classRoom.addStudent(Student("Charlie", 88));
    classRoom.addStudent(Student("Diana", 92));


    string topper = classRoom.findTopper();
    cout << "The topper in the class is: " << topper << endl;

    return 0;
}
