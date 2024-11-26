#include<bits/stdc++.h>
using namespace std;

class data1{
    private:
        int date;
        int month;
        int year;

    public:
       data1(){
           date=1;
           month=3;
           year=1993;
       }
       data1(int date,int month,int year){
           this->date=date;
           this->month=month;
           this->year=year;
       }
       void printdata(){
        cout<<date<<endl;
        cout<<month<<endl;
        cout<<year<<endl;
       }
};

int main(){
    data1 d1,d2;
   d1.printdata();
   d2=d1;
   d2.printdata();
}