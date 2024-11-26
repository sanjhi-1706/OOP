#include<bits/stdc++.h>
using namespace std;

class cube;
class cuboid{
    float l;
    float b;
    float h;
    float surfacearea;

    public:

    void getedges(){
        cout<<"enter length:";
        cin>>l;
        cout<<"enter breadth:";
        cin>>b;
        cout<<"enter height:";
        cin>>h;
    }
    void area(){
         surfacearea=2*(l*b+b*h+h*l);
    }
    void display(){
        cout<<surfacearea<<endl;
    }
     friend class cube;
};


class cube{
    float s;
   
public:
    void getside(cuboid c2){
    float sidesquare=c2.surfacearea/6;
    s=sqrt(sidesquare);
    cout<<s<<endl;
    }
    
};
int main(){
    cube C;
    cuboid B;
    B.getedges();
    B.area();
    B.display();
    C.getside(B);
}