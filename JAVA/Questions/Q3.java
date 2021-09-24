/* Prime nos to another file*/

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
            FileWriter primeFile = new FileWriter("prime.txt");

            Scanner dataRead = new Scanner(dataFile);
            while (dataRead.hasNextLine()) {
                data += dataRead.nextLine();
            }
            dataRead.close();

            String values[] = data.split(" ");

            for (String i : values) {
                int flag=0;
                int no = Integer.parseInt(i);
                for (int l = 2; l <= no / 2; l++) {
                    if (no % l == 0) {
                        flag=1;
                    }
                }
                if(flag==0 && no!=1){
                    primeFile.write(i+" ");
                }
            }
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