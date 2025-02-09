#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
  int data;
  struct Node *next;
} Node;

Node* createNewNode(){
  Node *newNode = (Node*)malloc(sizeof(Node));
  if (NULL == newNode){
      fprintf(stderr, "Memory allocation failed \n");
      exit(EXIT_FAILURE);
  }
  return newNode;
}

void insertAtBegin(Node **head, int data){
  Node *newNode = createNewNode();
  newNode->data = data;
  newNode->next = *head;
  *head = newNode;
}

void insertAtEnd(Node **head, int data){
  Node *newNode = createNewNode();
  newNode->data = data;
  newNode->next = NULL;

  if (NULL==*head){
    *head = newNode;
    return;
  }

  Node *temp = *head;
  while(NULL!=temp->next){
    temp = temp->next;
  }
  temp->next = newNode;
}

void deleteNode(Node **head, int data){
  Node *temp = *head, *prev = NULL;

  if (temp != NULL && temp->data == data){
    *head = temp->next;
    free(temp);
    return;
  }

  while (temp != NULL && temp->data != data){
    prev = temp;
    temp = temp->next;
  }

  if (temp == NULL) return;
  prev->next = temp->next;
  free(temp);
}

Node *search(Node *head, int data){
  Node *cur = head;
  while (NULL!=cur){
    if (cur->data==data){
      return cur;
    }
    cur = cur->next;
  }
  return NULL;
}

void print(Node *node){
  while (NULL!=node){
    printf("%d ", node->data);
    node = node->next;
  }
  printf("\n");
}

void freeList(Node *head){
  Node *cur = head;
  Node *next;
  while(NULL!=cur){
    next = cur->next;
    free(cur);
    cur = next;
  }
}

int main(){
  Node *head = NULL;
  insertAtBegin(&head, 30);
  insertAtBegin(&head, 20);
  insertAtBegin(&head, 10);
  insertAtEnd(&head, 40);
  insertAtEnd(&head, 50);
  print(head);

  deleteNode(&head, 40);
  print(head);

  Node* res = search(head, 4);
  if (NULL!=res) {
     printf("Found %d in the list\n", res->data);
  } else {
     printf("4 not found in the list\n");
  }
  freeList(head);
  return 0;
}