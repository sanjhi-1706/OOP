#include<bits/stdc++.h>
using namespace std;

struct Publication{
    string title;
    double price;
    string authorname;


    void input(){
    cout<<"enter title:";
    cin>>title;
    getline(cin,title);
    cout<<"enter the price:";
    cin>>price;
    cout<<"enter authorname:";
    cin>>authorname;
    getline(cin,authorname);
}

   void display(){
    cout<<"name of customer is:"<<title<<endl;
    cout<<"price"<<price<<endl;
    cout<<"name of the author"<<authorname<<endl;
   }
};

struct Book:public Publication{
    int count;

   void input(){
    Publication::input();
        cout<<"enter count for book:";
        cin>>count;
    }
    void display(){
        cout<<"count:"<<count<<endl;
    }
};

struct Ebook:public Publication{
    double time;
    void input(){
        Publication::input();
        cout<<"enter count for ebook:";
        cin>>time;
    }
    void display(){
        cout<<"time taken:"<<time<<endl;
    }
};
int main(){
    Book book1;
    Ebook ebook1;

    book1.input();
    book1.display();
    ebook1.input();
    ebook1.display();
}