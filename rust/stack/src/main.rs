mod stack;

use stack::Stack;

fn main() {
    let mut s: Stack<i32> = Stack::new(5);
    s.push(100);
    s.push(200);
    s.push(300);
    s.print_stack();

    println!("Top element: {:?}", s.peek());
    println!("Pop: {:?}", s.pop());
    println!("Pop: {:?}", s.pop());
    
    if s.is_empty() {
        println!("Stack is empty.");
    } else {
        println!("Stack is not empty.");
    }
    s.print_stack();
}