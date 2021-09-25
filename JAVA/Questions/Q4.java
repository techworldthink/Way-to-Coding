
/*Count the occurrences of numbers from the file and print the highest occuring number*/

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
    static File dataFile = new File("DATA.txt");

    public static void main(String[] arg) {
        try {
            FileWriter primeFile = new FileWriter("prime.txt");

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();

            String values[] = data.split(" ");

            Set<String> set = new HashSet<>(Arrays.asList(values));

            int countMax = 0;
            int frequency = 0;
            String mostSeen = "";

            for (String i : set) {
                frequency = 0;
                for (String j : values) {
                    if(i.equals(j)){
                        frequency++;
                    }
                }
                if(frequency>countMax){
                    countMax = frequency;
                    mostSeen = i;
                }
            }

            System.out.println("Most occurence element :"+mostSeen+"\nCount : "+countMax);

            primeFile.close();
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.print("An error occured : ");
            System.out.println(ex.getMessage());
        }

    }
}