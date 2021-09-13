import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    static String data = "";
    static File dataFile = new File("DATA.txt");

    public static void main(String[] arg) {
        try {
            FileWriter oddFile = new FileWriter("odd.txt", true);
            FileWriter evenFile = new FileWriter("even.txt", true);

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();
            String values[] = data.split(" ");
            int valuesInt[] = new int[values.length + 1];
            int count = 0;
            for (String i : values) {
                valuesInt[count++] = Integer.parseInt(i);
                //System.out.println(Integer.parseInt(i));
                if (Integer.parseInt(i) % 2 == 0) {
                    evenFile.write(i+" ");

                } else {
                    oddFile.write(i+" ");
                }
            }
            oddFile.close();
            evenFile.close();
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.print("An error occured : ");
            System.out.println(ex.getMessage());
        }

    }
}