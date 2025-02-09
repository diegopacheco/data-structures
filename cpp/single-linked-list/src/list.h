struct Node{
    int data;
    Node* next;
};

void insertAtBegin(Node*& head, int data);
void insertAtEnd(Node*& head, int data);
void deleteNode(Node*& head, int data);
bool searchNode(Node* head, int data);
void printList(Node* head);