#include<bits/stdc++.h>
using namespace std;


class Integer {
    friend class Vector;
private:
    int i;

public:
     Integer(){
        i=0;
     }
};

 class Vector{
    int a;

    public:
   int* arr = new int[a];

    Vector(int n){
        a=n;
    }

    void getdata(){
         for(int i=0;i<a;i++){
            cout<<"enter ";
            cin>>arr[i];
        }
    }
    void display(){
        for(int i=0;i<a;i++){
            cout<<arr[i];
        }
       
    }
   
        
    
  friend void operator<<(ostream &os, Vector &obj){
       os << obj.a;
    }
    friend void operator>>(istream &is, Vector &obj){
        is >> obj.a;
    }
 };

 #include <iostream>

using namespace std;

class Vector {
private:
    int* arr;
    int size;

public:
    Vector(int s) : size(s) {
        arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = 0;
        }
    }

    ~Vector() {
        delete[] arr;
    }

    void setValueAt(int index, int value) {
        if (index >= 0 && index < size) {
            arr[index] = value;
        }
    }

    int getValueAt(int index) const {
        if (index >= 0 && index < size) {
            return arr[index];
        }
        return 0;
    }

    Vector operator-(const Vector& other) const {
        if (size != other.size) {
            cerr << "Error: Vectors must be of the same size for subtraction." << endl;
            return Vector(0);
        }
        Vector result(size);
        for (int i = 0; i < size; ++i) {
            result.arr[i] = arr[i] - other.arr[i];
        }
        return result;
    }

    friend ostream& operator<<(ostream& os, const Vector& vec);
};

ostream& operator<<(ostream& os, const Vector& vec) {
    os << "[ ";
    for (int i = 0; i < vec.size; ++i) {
        os << vec.arr[i] << " ";
    }
    os << "]";
    return os;
}

int main() {
    int size;

    cout << "Enter the number of elements in the vectors: ";
    cin >> size;

    Vector vector1(size);
    Vector vector2(size);

    cout << "Enter values for the first vector:" << endl;
    for (int i = 0; i < size; ++i) {
        int value;
        cout << "Element " << i << ": ";
        cin >> value;
        vector1.setValueAt(i, value);
    }

    cout << "Enter values for the second vector:" << endl;
    for (int i = 0; i < size; ++i) {
        int value;
        cout << "Element " << i << ": ";
        cin >> value;
        vector2.setValueAt(i, value);
    }

    Vector result = vector1 - vector2;

    cout << "Result of vector subtraction: " << result << endl;

    return 0;
}


int main(){
    Vector v1(10);
    v1.getdata();
    v1.display();

}