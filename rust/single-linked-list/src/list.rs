#[derive(Debug)]
struct Node {
    data: i32,
    next: Option<Box<Node>>,
}

pub struct LinkedList {
    head: Option<Box<Node>>,
}

impl LinkedList {
    pub fn new() -> Self {
        LinkedList { head: None }
    }

    pub fn insert_at_begin(&mut self, data: i32) {
        let new_node = Node {
            data,
            next: self.head.take(),
        };
        self.head = Some(Box::new(new_node));
    }

    pub fn insert_at_end(&mut self, data: i32) {
        let new_node = Box::new(Node {
            data,
            next: None,
        });

        match &mut self.head {
            None => {
                self.head = Some(new_node);
            }
            Some(head) => {
                let mut current = head;
                while current.next.is_some() {
                    current = current.next.as_mut().unwrap();
                }
                current.next = Some(new_node);
            }
        }
    }

    pub fn delete_node(&mut self, data: i32) {
        match &mut self.head {
            None => return,
            Some(head) => {
                if head.data == data {
                    self.head = head.next.take();
                    return;
                }

                let mut current = head;
                while current.next.is_some() {
                    if current.next.as_ref().unwrap().data == data {
                        current.next = current.next.take().unwrap().next;
                        return;
                    }
                    current = current.next.as_mut().unwrap();
                }
            }
        }
    }

    pub fn search_node(&self, data: i32) -> bool {
        let mut current = &self.head;
        while let Some(node) = current {
            if node.data == data {
                return true;
            }
            current = &node.next;
        }
        false
    }

    pub fn print_list(&self) {
        let mut current = &self.head;
        while let Some(node) = current {
            print!("{} ", node.data);
            current = &node.next;
        }
        println!();
    }
}