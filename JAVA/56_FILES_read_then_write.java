import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    static String data="";
    public static void main(String[] arg) {
        // Read
        try {
            File dataFile = new File("DATA.txt");
            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        }
        // Write
        try {
            FileWriter dataWriter = new FileWriter("DATA2.txt");
            dataWriter.write(data);
            dataWriter.close();
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        }

    }
}