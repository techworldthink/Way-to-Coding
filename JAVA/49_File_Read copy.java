import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        try{
            File dataFile = new File("DATA.txt");
            Scanner dataRead = new Scanner(dataFile);
            while(dataRead.hasNextLine()){
                System.out.println(dataRead.nextLine());
            }
            dataRead.close();
        }catch(FileNotFoundException ex){
            System.out.println("An error occured !");
            ex.printStackTrace();
        }
    }
}