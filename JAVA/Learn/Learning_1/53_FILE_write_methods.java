
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

class TextFileWritingExample1 {
 
    public static void main(String[] args) {
        //------- method 1
        try {
            FileWriter writer = new FileWriter("D1.txt", true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //------- method 2
        try {
            FileWriter writer = new FileWriter("D2.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("See You Again!");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}