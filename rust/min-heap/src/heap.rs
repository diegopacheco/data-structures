pub struct MinHeap {
    heap: Vec<i32>,
}

impl MinHeap {
    pub fn new() -> Self {
        MinHeap { heap: Vec::new() }
    }

    pub fn insert(&mut self, value: i32) {
        self.heap.push(value);
        self.heapify_up(self.heap.len() - 1);
    }

    pub fn extract_min(&mut self) -> Option<i32> {
        if self.heap.is_empty() {
            println!("Heap is empty");
            return None;
        }

        if self.heap.len() == 1 {
            return self.heap.pop();
        }

        let min = self.heap.swap_remove(0);
        self.heapify_down(0);
        Some(min)
    }

    pub fn get_min(&self) -> Option<&i32> {
        self.heap.first()
    }

    fn heapify_up(&mut self, index: usize) {
        let mut current_index = index;

        while current_index > 0 && self.heap[current_index] < self.heap[self.parent(current_index)] {
            self.swap(current_index, self.parent(current_index));
            current_index = self.parent(current_index);
        }
    }

    fn heapify_down(&mut self, index: usize) {
        let mut current_index = index;

        loop {
            let left_index = self.left_child(current_index);
            let right_index = self.right_child(current_index);
            let mut smallest = current_index;

            if left_index < self.heap.len() && self.heap[left_index] < self.heap[smallest] {
                smallest = left_index;
            }

            if right_index < self.heap.len() && self.heap[right_index] < self.heap[smallest] {
                smallest = right_index;
            }

            if smallest != current_index {
                self.swap(current_index, smallest);
                current_index = smallest;
            } else {
                break;
            }
        }
    }

    fn parent(&self, index: usize) -> usize {
        (index - 1) / 2
    }

    fn left_child(&self, index: usize) -> usize {
        2 * index + 1
    }

    fn right_child(&self, index: usize) -> usize {
        2 * index + 2
    }

    fn swap(&mut self, i: usize, j: usize) {
        self.heap.swap(i, j);
    }

    pub fn print_heap(&self) {
        print!("Min Heap: ");
        for &val in &self.heap {
            print!("{} ", val);
        }
        println!();
    }
}