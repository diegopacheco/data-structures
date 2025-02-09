#include <iostream>
#include "list.h"
using namespace std;

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
