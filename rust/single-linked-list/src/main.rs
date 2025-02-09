#[derive(Debug)]
struct Node {
    data: i32,
    next: Option<Box<Node>>,
}

struct LinkedList {
    head: Option<Box<Node>>,
}

impl LinkedList {
    fn new() -> Self {
        LinkedList { head: None }
    }

    fn insert_at_begin(&mut self, data: i32) {
        let new_node = Node {
            data,
            next: self.head.take(),
        };
        self.head = Some(Box::new(new_node));
    }

    fn insert_at_end(&mut self, data: i32) {
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
                while let Some(node) = &mut current.next {
                    current = node;
                }
                current.next = Some(new_node);
            }
        }
    }

    fn delete_node(&mut self, data: i32) {
        match &mut self.head {
            None => return,
            Some(head) => {
                if head.data == data {
                    self.head = head.next.take();
                    return;
                }

                let mut current = head;
                while let Some(node) = &mut current.next {
                    if node.data == data {
                        current.next = node.next.take();
                        return;
                    }
                    current = node;
                }
            }
        }
    }

    fn search_node(&self, data: i32) -> bool {
        let mut current = &self.head;
        while let Some(node) = current {
            if node.data == data {
                return true;
            }
            current = &node.next;
        }
        false
    }

    fn print_list(&self) {
        let mut current = &self.head;
        while let Some(node) = current {
            print!("{} ", node.data);
            current = &node.next;
        }
        println!();
    }
}

fn main() {
    let mut list = LinkedList::new();

    list.insert_at_begin(30);
    list.insert_at_begin(20);
    list.insert_at_begin(10);
    list.insert_at_end(40);
    list.insert_at_end(50);

    println!("List: ");
    list.print_list();

    list.delete_node(40);
    println!("List after deleting 40: ");
    list.print_list();

    if list.search_node(4) {
        println!("4 is in the list");
    } else {
        println!("4 is not in the list");
    }
}