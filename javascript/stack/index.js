import Stack from "./stack.js";

const stack = new Stack(5);
stack.push(100);
stack.push(200);
stack.push(300);
stack.printStack();

console.log("Top element:", stack.peek());
console.log("Pop:", stack.pop());
console.log("Pop:", stack.pop());

if (stack.isEmpty()) {
  console.log("Stack is now empty.");
} else {
  console.log("Stack is not empty.");
}
stack.printStack();