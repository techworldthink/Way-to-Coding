import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    static String data = "";
    static File dataFile = new File("myFile.txt");

    public static void main(String[] arg) {
        int wCount = 0;
        int lCount = 0;
        int vCount = 0;

        String[] vowels = { "a", "e", "i", "o", "u", "A", "E", "I", "O", "U" };
        try {

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();

            lCount = data.length();
            
            String values[] = data.split("");
            String values2[] = data.split(" ");
            wCount = values2.length;

            for (String i : values) {
                for (String j : vowels) {
                    if (i.equals(j)) {
                        vCount++;
                    }
                }
            }

            System.out.println("Word Count : "+wCount);
            System.out.println("Charecter Count : "+lCount);
            System.out.println("Vowels Count : "+vCount);
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.print("An error occured : ");
            System.out.println(ex.getMessage());
        }

    }
}