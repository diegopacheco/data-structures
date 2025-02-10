use std::fmt::Debug;

pub trait Queue<T> {
    fn enqueue(&mut self, item: T);
    fn dequeue(&mut self) -> Option<T>;
    fn peek(&self) -> Option<&T>;
    fn is_empty(&self) -> bool;
    fn is_full(&self) -> bool;
    fn print_queue(&self);
}

pub struct SimpleQueue<T> {
    items: Vec<T>,
    capacity: usize,
}

impl<T> SimpleQueue<T> {
    pub fn new(capacity: usize) -> Self {
        SimpleQueue {
            items: Vec::with_capacity(capacity),
            capacity,
        }
    }
}

impl<T: Debug> Queue<T> for SimpleQueue<T> {
    fn enqueue(&mut self, item: T) {
        if self.is_full() {
            println!("Queue overflow");
            return;
        }
        self.items.push(item);
    }

    fn dequeue(&mut self) -> Option<T> {
        if self.is_empty() {
            println!("Queue underflow");
            return None;
        }
        if self.items.len() > 0 {
            return Some(self.items.remove(0));
        } else {
            return None
        }
    }

    fn peek(&self) -> Option<&T> {
        if self.is_empty() {
            return None;
        }
        self.items.first()
    }

    fn is_empty(&self) -> bool {
        self.items.is_empty()
    }

    fn is_full(&self) -> bool {
        self.items.len() >= self.capacity
    }

    fn print_queue(&self) {
        println!("Queue: {:?}", self.items);
    }
}