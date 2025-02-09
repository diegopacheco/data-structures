#ifndef LIST_H
#define LIST_H

typedef struct Node{
  int data;
  struct Node *next;
} Node;

Node* createNewNode();
void insertAtBegin(Node **head, int data);
void insertAtEnd(Node **head, int data);
void deleteNode(Node **head, int data);
Node *search(Node *head, int data);
void print(Node *node);
void freeList(Node **head);

#endif