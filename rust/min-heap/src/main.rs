mod heap;
use heap::MinHeap;

fn main() {
    let mut heap = MinHeap::new();
    heap.insert(3);
    heap.insert(2);
    heap.insert(15);
    heap.insert(5);
    heap.insert(4);
    heap.insert(45);
    heap.print_heap();
    
    println!("Minimum element: {}", heap.get_min().unwrap());
    println!("Extracted min: {}", heap.extract_min().unwrap());
    heap.print_heap();
}