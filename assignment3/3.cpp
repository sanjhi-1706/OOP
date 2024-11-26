#include<bits/stdc++.h>
using namespace std;

class employee{
    private:
    string name;
    int income;
    double bill;

    public:
    void input(){
    cout<<"enter name of the employee:";
    cin>>name;
    getline(cin,name);
    cout<<"enter the no of income:";
    cin>>income;
 }

void calculating(){
    if(income<=100000){
        bill=0;
    }
    else if(income>100000 && income<=150000){
        bill=0+(income-100000)*0.10;
    }
    else if(income>150000 && income<=200000){
        bill=0+(income-150000)*0.20;
    }
    else{
         bill=0+(income-200000)*0.30;
    }
}

void output(){
    cout<<name<<endl;
    cout<<" income of the employee:"<<income<<endl;
    cout<<bill;
}
};

int main(){
    employee employee;
    employee.input();
    employee.calculating();
    employee.output();

    return 0;


}