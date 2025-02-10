mod queue;

use queue::{Queue, SimpleQueue};

fn main() {
    let mut q: SimpleQueue<i32> = SimpleQueue::new(5);
    q.enqueue(100);
    q.enqueue(200);
    q.enqueue(300);
    q.print_queue();

    println!("Peek: {:?}", q.peek());
    println!("Dequeue: {:?}", q.dequeue());
    println!("Dequeue: {:?}", q.dequeue());

    if q.is_empty() {
        println!("Queue is empty");
    } else {
        println!("Queue is not empty");
    }

    q.print_queue();
}