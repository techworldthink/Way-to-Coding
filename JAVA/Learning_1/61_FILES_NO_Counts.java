import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Main {
    static String data = "";
    static File dataFile = new File("mynum.txt");

    public static void main(String[] arg) {

        try {

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine()+" ";
            }
            dataRead.close();
            String []values = data.split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(values));
            int count=0;
            for (String i : set) {
                for (String j : values) {
                    if (i.equals(j)) {
                        count++;
                    }
                }
                System.out.println("Count of "+i+" is "+count);
                count=0;
            }

            
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.print("An error occured : ");
            System.out.println(ex.getMessage());
        }

    }
}