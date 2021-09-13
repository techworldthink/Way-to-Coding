import java.util.Scanner;

class test {
    public static void main(String[] arg){
        //Scanner sc = new Scanner(System.in);
        //String searchName = sc.nextLine();
        //System.out.print("\nFile Name : " + searchName);
        String file="1.txt";
        String[] fileNameOnly = file.split("\\.", 3);
        for (String i : fileNameOnly)
            System.out.print(i + " ");
    }
}
