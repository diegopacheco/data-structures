#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "stack.h"

int main(){
  Stack s;
  initStack(&s);

  push(&s, 100);
  push(&s, 200);
  push(&s, 300);
  fprintf(stdout, "Top: %d\n", peek(&s));
  fprintf(stdout, "Pop: %d\n", pop(&s));
  fprintf(stdout, "Pop: %d\n", pop(&s));

  if (isEmpty(&s)){
      fprintf(stdout, "Stack is empty\n");
  } else {
      fprintf(stdout, "Stack is not empty\n");
  }
  return 0;
}