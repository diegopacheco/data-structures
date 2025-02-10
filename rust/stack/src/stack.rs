use std::fmt::Debug;

pub struct Stack<T> {
    items: Vec<T>,
    capacity: usize,
}

impl<T: Debug> Stack<T> {
    pub fn new(capacity: usize) -> Self {
        Stack {
            items: Vec::with_capacity(capacity),
            capacity,
        }
    }

    pub fn is_empty(&self) -> bool {
        self.items.is_empty()
    }

    pub fn is_full(&self) -> bool {
        self.items.len() == self.capacity
    }

    pub fn push(&mut self, data: T) {
        if self.is_full() {
            println!("Stack overflow!");
        } else {
            self.items.push(data);
        }
    }

    pub fn pop(&mut self) -> Option<T> {
        if self.is_empty() {
            println!("Stack underflow!");
            None
        } else {
            self.items.pop()
        }
    }

    pub fn peek(&self) -> Option<&T> {
        self.items.last()
    }

    pub fn print_stack(&self) {
        for item in &self.items {
            println!("{:?}", item);
        }
    }
}