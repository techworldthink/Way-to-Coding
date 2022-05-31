public class Main {
  public static void main(String[] args) {
    try {
      int a = 2 / 0;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      try {
        int a = 2 / 0;
      } catch (NumberFormatException ex) {
        System.out.println(ex.getMessage());
      }
    } catch (ArithmeticException ex) {
      System.out.println(ex.getMessage());
    }
  }
}