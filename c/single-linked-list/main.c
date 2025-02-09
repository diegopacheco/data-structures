#include <stdio.h>
#include <stdlib.h>
#include "list.h"

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
  freeList(&head);
  return 0;
}