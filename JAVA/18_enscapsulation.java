public class Main {
    public static void main(String[] args) {
      Person myObj = new Person();
      myObj.setName("John"); // Set the value of the name variable to "John"
      System.out.println(myObj.getName());
    }
  }

class Person {
    private String name; // private = restricted access
  
    // Getter
    public String getName() {
      return name;
    }
  
    // Setter
    public void setName(String newName) {
      this.name = newName;
    }
  }