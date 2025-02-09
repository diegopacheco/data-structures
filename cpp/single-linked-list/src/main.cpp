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

void insertAtEnd(Node*& head, int data){
    Node *newNode = new Node();
    newNode->data = data;
    newNode->next = NULL;

    if (!head){
        head = newNode;
        return;
    }
    Node *temp = head;
    while(temp->next){
        temp = temp->next;
    }
    temp->next = newNode;
}

void deleteNode(Node*& head, int data){
    if (!head) return;
    if (head->data == data){
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }
    Node* cur = head;
    while(cur->next && cur->next->data != data){
        cur = cur->next;
    }
    if (!cur->next){
        Node * temp = cur->next;
        cur->next = cur->next->next;
        delete temp;
    }
}

bool searchNode(Node* head, int data) {
    while (head) {
        if (head->data == data) return true;
        head = head->next;
    }
    return false;
}

void printList(Node* head){
    while(head){
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main(){
    Node* head = NULL;
    insertAtBegin(head, 30);
    insertAtBegin(head, 20);
    insertAtBegin(head, 10);
    insertAtEnd(head, 40);
    insertAtEnd(head, 50);

    cout << "List: ";
    printList(head);

    deleteNode(head, 40);
    cout << "List: ";
    printList(head);

    if (searchNode(head, 4)){
        cout << "4 is in the list" << endl;
    } else {
        cout << "4 is not in the list" << endl;
    }

    return 0;
}
