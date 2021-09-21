import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    static String data = "";
    static File dataFile = new File("myFile.txt");

    public static void main(String[] arg) {
        String[] vowels = { "a", "e", "i", "o", "u", "A", "E", "I", "O", "U" };
        try {
            FileWriter vowelsFile = new FileWriter("vowels.txt", true);

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();
            String values[] = data.split("");
            for (String i : values) {
                for (String j : vowels) {
                    if (i.equals(j)) {
                        vowelsFile.write(i + " ");
                    }
                }
            }

            vowelsFile.close();
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.print("An error occured : ");
            System.out.println(ex.getMessage());
        }

    }
}