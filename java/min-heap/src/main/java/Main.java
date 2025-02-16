public class Main {
  public static void main(String[] args) {
      SimpleHeap heap = new SimpleHeap(10);
      heap.insert(3);
      heap.insert(2);
      heap.insert(15);
      heap.insert(5);
      heap.insert(4);
      heap.insert(45);
      heap.printHeap();
      
      System.out.println("Minimum element: " + heap.getMin());
      System.out.println("Extracted min: " + heap.extractMin());
      heap.printHeap();
  }
}