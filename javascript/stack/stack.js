export default class Stack {
    
    constructor(capacity = 5) {
      this.items = new Array(capacity);
      this.top = -1;
      this.capacity = capacity;
    }
  
    isEmpty() {
      return this.top === -1;
    }
  
    isFull() {
      return this.top === this.capacity - 1;
    }
  
    push(value) {
      if (this.isFull()) {
        console.log("Stack overflow.");
        return;
      }
      this.items[++this.top] = value;
    }
  
    pop() {
      if (this.isEmpty()) {
        console.log("Stack underflow.");
        return undefined;
      }
      return this.items[this.top--];
    }
  
    peek() {
      if (this.isEmpty()) {
        console.log("Stack is empty.");
        return undefined;
      }
      return this.items[this.top];
    }

    printStack() {
        if (this.isEmpty()) {
            console.log("Stack is empty.");
            return;
        }
        for (let i = 0; i <= this.top; i++) {
            console.log(this.items[i]);
        }
    }

  }