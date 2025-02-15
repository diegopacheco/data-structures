#[derive(Debug)]
struct Node {
    data: i32,
    left: Option<Box<Node>>,
    right: Option<Box<Node>>,
}

#[derive(Debug)]
pub struct BST {
    root: Option<Box<Node>>,
}

impl BST {
    pub fn new() -> Self {
        BST { root: None }
    }

    pub fn insert(&mut self, data: i32) {
        let root = self.root.take();
        self.root = self.insert_node(root, data);
    }

    fn insert_node(&mut self, node: Option<Box<Node>>, data: i32) -> Option<Box<Node>> {
        match node {
            None => Some(Box::new(Node { data, left: None, right: None })),
            Some(mut n) => {
                if data < n.data {
                    n.left = self.insert_node(n.left.take(), data);
                } else if data > n.data {
                    n.right = self.insert_node(n.right.take(), data);
                }
                Some(n)
            }
        }
    }

    pub fn search(&self, data: i32) -> bool {
        self.search_node(&self.root, data)
    }

    fn search_node(&self, node: &Option<Box<Node>>, data: i32) -> bool {
        match node {
            None => false,
            Some(n) => {
                if data == n.data {
                    true
                } else if data < n.data {
                    self.search_node(&n.left, data)
                } else {
                    self.search_node(&n.right, data)
                }
            }
        }
    }

    pub fn remove(&mut self, data: i32) {
        let root = self.root.take();
        self.root = self.remove_node(root, data);
    }

    fn remove_node(&mut self, node: Option<Box<Node>>, data: i32) -> Option<Box<Node>> {
        match node {
            None => None,
            Some(mut n) => {
                if data < n.data {
                    n.left = self.remove_node(n.left.take(), data);
                } else if data > n.data {
                    n.right = self.remove_node(n.right.take(), data);
                } else {
                    if n.left.is_none() {
                        return n.right;
                    } else if n.right.is_none() {
                        return n.left;
                    }

                    let temp = self.find_min(n.right.as_ref().unwrap());
                    n.data = temp;
                    n.right = self.remove_node(n.right.take(), temp);
                }
                Some(n)
            }
        }
    }

    fn find_min(&self, node: &Node) -> i32 {
        let mut current = node;
        while let Some(ref left) = current.left {
            current = left;
        }
        current.data
    }

    pub fn inorder_traversal(&self) {
        self.inorder_traversal_node(&self.root);
        println!();
    }

    fn inorder_traversal_node(&self, node: &Option<Box<Node>>) {
        if let Some(n) = node {
            self.inorder_traversal_node(&n.left);
            print!("{} ", n.data);
            self.inorder_traversal_node(&n.right);
        }
    }

    pub fn preorder_traversal(&self) {
        self.preorder_traversal_node(&self.root);
        println!();
    }

    fn preorder_traversal_node(&self, node: &Option<Box<Node>>) {
        if let Some(n) = node {
            print!("{} ", n.data);
            self.preorder_traversal_node(&n.left);
            self.preorder_traversal_node(&n.right);
        }
    }

    pub fn postorder_traversal(&self) {
        self.postorder_traversal_node(&self.root);
        println!();
    }

    fn postorder_traversal_node(&self, node: &Option<Box<Node>>) {
        if let Some(n) = node {
            self.postorder_traversal_node(&n.left);
            self.postorder_traversal_node(&n.right);
            print!("{} ", n.data);
        }
    }
}