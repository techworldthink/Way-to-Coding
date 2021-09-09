import java.io.File;
import java.io.IOException;

class Main {
    public static void main(String[] arg) {
        try {
            File dataFile = new File("DATA.txt");
            if (dataFile.createNewFile()) {
                System.out.println("File created : " + dataFile.getName());
            } else {
                System.out.println("File Exists : " + dataFile.getName());
            }
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        }
    }
}