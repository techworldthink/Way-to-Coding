import java.io.File;

class Main {
    public static void main(String[] args) {

        File dataFile = new File("DATA.txt");
        if (dataFile.exists()) {
            System.out.println("File name: " + dataFile.getName());
            System.out.println("Absolute path: " + dataFile.getAbsolutePath());
            System.out.println("Writeable: " + dataFile.canWrite());
            System.out.println("Readable " + dataFile.canRead());
            System.out.println("File size in bytes " + dataFile.length());
          } else {
            System.out.println("The file does not exist.");
          }
    }
}