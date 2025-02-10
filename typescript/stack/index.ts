import Stack from "./stack";

const stack = new Stack<number>(5);
stack.push(100);
stack.push(200);
stack.push(300);
stack.printStack();

console.log("Peek:", stack.peek());
console.log("Pop:", stack.pop());
console.log("Pop:", stack.pop());

if (stack.isEmpty()) {
    console.log("Stack is empty");
} else {
    console.log("Stack is not empty");
}
stack.printStack();