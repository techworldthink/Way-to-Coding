import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class listFiles {
    static LinkedList<String> fileList = new LinkedList<String>();
    static LinkedList<String> fileDir = new LinkedList<String>();

    static void listFD(String directoryName) {
        try {
            File fDir = new File(directoryName);
            File[] fList = fDir.listFiles();

            if (fList != null) {
                for (File file : fList) {
                    if (file.isFile()) {
                        fileList.add(file.getName());
                        System.out.println(file);
                    } else if (file.isDirectory()) {
                        fileDir.add(file.getName());
                        System.out.println(file);
                        listFD(file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int flag=0;
        String searchName;
        System.out.println("\n------ Files are -------\n");
        listFD("G:\\LIST");
        System.out.println("\n-------------------\n");
        System.out.println(fileList);
        System.out.println(fileDir);
        System.out.println("\n-------------------\n");
        System.out.print("\nEnter a file Name : ");
        searchName = sc.nextLine();
        System.out.print("\nFile Name : "+ searchName);

        for(String file : fileList){
            if(file.equals(searchName)){
                System.out.print("\nFile Found ");
                flag=1;
                break;
            }
        }

        if(flag==0){
            System.out.print("\nFile Not Found ");
        }
    }

}
