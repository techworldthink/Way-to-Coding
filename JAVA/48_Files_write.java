import java.io.FileWriter;
import java.io.IOException;

class Main {
    public static void main(String[] arg) {
        try {
            FileWriter dataWriter = new FileWriter("DATA1.txt");
            dataWriter.write("Hai Hallo");
            dataWriter.write(" World");
            dataWriter.close();
        } catch (IOException ex) {
            System.out.println("An error occured !");
            ex.printStackTrace();
        }
    }
}