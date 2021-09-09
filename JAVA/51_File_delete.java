import java.io.File;


class Main {
    public static void main(String[] arg) {

        File dataFile = new File("DATA.txt");
        if (dataFile.delete()) {
            System.out.println("File deleted : " + dataFile.getName());
        } else {
            System.out.println("File delete failed! : " + dataFile.getName());
        }

    }
}