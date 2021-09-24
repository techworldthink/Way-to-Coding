/* Student with highest percentage of mark..  use array of objects of class student*/

import java.util.Scanner; 

class Main{
    public static void main(String []args){
        int arrSize;
        int max=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Array size : ");
        arrSize = sc.nextInt();

        Student[] arrObj = new Student[arrSize];

        for(int i=0;i<arrSize;i++){
            arrObj[i] = new Student();
            arrObj[i].setValues();
            if(max < arrObj[i].getPrice()){
                max=arrObj[i].getPrice();
            }
        }
        System.out.println("---------HIGHEST------------");
        for(int i=0;i<arrSize;i++){
            if(max == arrObj[i].getPrice()){
                arrObj[i].show();
            }
        }
    }
}

class Student{
    int mark1;
    int mark2;
    int mark3;
    String name;
    int total;

    public void setValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------ENTER DETAILS------------");
        System.out.print("Name : ");
        this.name = sc.nextLine();
        System.out.print("Mark1 : ");
        this.mark1 = sc.nextInt();
        System.out.print("Mark2 : ");
        this.mark2 = sc.nextInt();
        System.out.print("Mark3 : ");
        this.mark3 = sc.nextInt();
        this.total = this.mark1+this.mark2+this.mark3;
    }

    public void show(){
        System.out.println("--------------------------------------------");
        System.out.println("Name : "+this.name);
        System.out.println("M1   : "+this.mark1);
        System.out.println("M2   : "+this.mark2);
        System.out.println("M3   : "+this.mark3);
        System.out.println("Total   : "+this.total);
    }

    public int getPrice(){
        return this.total;
    } 
}