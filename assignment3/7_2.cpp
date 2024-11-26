#include<bits/stdc++.h>
using namespace std;

class employee{
    int emp_id;
    string name;
    int emp_age;
    public:

    int getid(){
        return emp_id;
    }

   void input(){
    cout<<"enter employeeid:"<<endl;
    cin>>emp_id;
    cout<<"enter name :";
    cin>>name;
    getline(cin,name);
    cout<<"enter the age of employee:";
    cin>>emp_age;
}
};

int main(){
    employee emp[10];
    int found=0;
    for(int i=0;i<2;i++){
        cout<<"enter details for employee"<<i+1<<endl;
        emp[i].input();
    }
    int idsearch;
    cout<<"enter the id to be searched:"<<endl;
    cin>>idsearch;

    for(int j=0;j<2;j++){
        if(emp[j].getid()==idsearch){
            found=1;
            break;
        }
        else{
            found=0;
        }
    }
    if(found){
        cout<<"id found"<<endl;
    }
    else{
        cout<<"id not found";
    }

}
