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

    public static void main(String arg[]) {

        int flag = 0;

        System.out.println("\n------ Files are -------\n");
        listFD("G:\\LIST");
        System.out.println("\n-------------------\n");
        System.out.println(fileList);
        System.out.println(fileDir);
        System.out.println("\n-------------------\n");
        System.out.print("\nEnter a file Name : ");

        Scanner sc = new Scanner(System.in);
        String searchName = sc.nextLine();
        System.out.println("\nFile Name : " + searchName);
        sc.close();

        for (String file : fileList) {
            if (file.equals(searchName)) {
                System.out.print("\nFile Found :  " + searchName);
                flag = 1;
                break;
            } else {
                String[] fileNameOnly = file.split("\\.", 3);
                //for (String i : fileNameOnly)
                    //System.out.print(i + " ");
                if (searchName.equals(fileNameOnly[0])) {
                    System.out.print("\nFile Found :  " + file);
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.print("\nFile Not Found ");
        }

    }

}
