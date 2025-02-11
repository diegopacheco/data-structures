public class Main {
  public static void main(String[] args) {
      List<Integer> list = new LinkedList<>();
      list.add(10);
      list.add(20);
      list.add(30);
      list.add(40);
      list.add(50);
      System.out.println(list);
      
      list.remove(40);
      System.out.println(list);
      
      int searchValue = 4;
      System.out.printf("%d %s in the list%n", 
          searchValue, 
          list.contains(searchValue) ? "found" : "not found");
      System.out.println(list);
  }
}