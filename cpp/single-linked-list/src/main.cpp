#include <iostream>
using namespace std;

struct Node{
    int data;
    Node* next;
};

void insertAtBegin(Node*& head, int data){
    Node* newNode = new Node();
    newNode->data = data;
    newNode->next = head;
    head = newNode;
}

int main(){
    cout << "C++ works" << endl;
    return 0;
}
