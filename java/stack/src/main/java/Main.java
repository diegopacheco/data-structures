public class Main {
  public static void main(String[] args) {
      Stack<Integer> stack = new LinkedStack<>();

      stack.push(100);
      stack.push(200);
      stack.push(300);
      System.out.println(stack);

      System.out.println("Top: " + stack.top());
      System.out.println("Pop: " + stack.pop());
      System.out.println("Pop: " + stack.pop());
      
      System.out.println("Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
      System.out.println(stack);
  }
}