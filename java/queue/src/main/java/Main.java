public class Main {
  public static void main(String[] args) {
      Queue<Integer> queue = new LinkedQueue<>();

      queue.enqueue(100);
      queue.enqueue(200);
      queue.enqueue(300);
      System.out.println(queue);

      System.out.println("Front element: " + queue.front());
      System.out.println("Dequeued: " + queue.dequeue());
      System.out.println("Dequeued: " + queue.dequeue());

      System.out.println("Queue is " + 
      (queue.isEmpty() ? "empty" : "not empty"));
      System.out.println(queue);
  }
}