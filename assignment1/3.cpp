#include<bits/stdc++.h>
using namespace std;

struct Publication{
    string title;
    double price;
    string authorname;


    void input(){
    cout<<"enter name of the customer:";
    cin>>title;
    getline(cin,title);
    cout<<"enter the price:";
    cin>>price;
    cout<<"enter authorname:";
    cin>>authorname;
    getline(cin,authorname);
}
};

struct Book:public Publication{
    int count;

   void input(){
    Publication::input();
        cout<<"enter count for book:";
        cin>>count;
    }
};

struct Ebook:public Publication{
    double time;
    void input(){
        Publication::input();
        cout<<"enter count for ebook:";
        cin>>time;
    }
};
int main(){
    Book book1;
    Ebook ebook1;

    book1.input();
    ebook1.input();
}