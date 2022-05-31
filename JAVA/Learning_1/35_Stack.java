import java.util.*;

class stack_list {
    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        int n;
        // Stack<integer> s = new Stack<integer>();
        do {
            System.out.println("\n\t\t\tSTACK LIST");
            System.out.println("\n\t\t==========================");
            System.out.println("\n\t 1.ADD");
            System.out.println("\n\t 2.SIZE");
            System.out.println("\n\t 3.PEEK");
            System.out.println("\n\t 4.POP");
            System.out.println("\n\t 5.SEARCH");
            System.out.println("\n\t 6.TRAVERSAL");
            System.out.println("\n\t 7.REMOVE");
            System.out.println("\n\t 8.EXIT");
            System.out.print("\n\t\t enter your choice = ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    s.add(100);
                    System.out.println("\n\tnew stack = " + s);
                    break;
                case 2:
                    System.out.println("\n\t the size of the stack = " + s.size());
                    break;
                case 3:
                    System.out.println("\n\t peek of the stack = " + s.peek());
                    break;
                case 4:
                    System.out.println("\n\t pop of the stack = " + s.pop());
                    break;
                case 5:
                    System.out.println("\n\t searching element of the stack = " + s.search(400));
                    break;
                case 6:
                    for (Integer i : s)
                        System.out.println("\n\ttraversing each element in the stack = " + i + " ");
                    break;
                case 7:
                    System.out.println("\n\t removing ana element in the stack = " + s.remove(0));
                    System.out.println("\n\t new stack = " + s);
                    break;
                case 8:
                    System.out.println("\n\t program exiting...!!!!!");
                    break;
                default:
                    System.out.println("\n\t try another menu.....");
            }

        } while (n != 8);
    }
}